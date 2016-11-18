/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.hofon.member.common.model.Merchant;
import com.hofon.trade.facade.model.TradeGoods;
import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.model.CreateTrade;
import com.hofon.tradegw.facade.model.Exchange;
import com.hofon.tradegw.facade.model.Product;
import com.hofon.tradegw.facade.model.Royalty;
import com.hofon.tradegw.facade.model.TradeRes;
import com.hofon.tradegw.facade.model.TradeState;
import com.hofon.tradegw.facade.request.CreateTradeRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.CreateTradeResponse;
import com.zhuking.biz.common.domain.BizCode;
import com.zhuking.biz.common.domain.SplitTag;
import com.zhuking.biz.common.domain.TradeType;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.DateUtil;
import com.zhuking.common.util.JsonUtil;
import com.zhuking.service.domain.SplitParty;
import com.zhuking.service.exception.BizException;

/**
 * 交易下单-处理器
 * @author xilu.tong
 * @version $Id: CreateTradeHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "create_trade")
public class CreateTradeHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(CreateTradeHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            CreateTradeResponse response = new CreateTradeResponse();
            // 参数转换
            CreateTradeRequest request = JsonUtil.json2Obj(jsonRequest, CreateTradeRequest.class);
            // 基本参数校验
            validateParam(request);
            // 登录验证
            if (getMemberBasicInfoFromCache(request.getToken()) == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            List<CreateTrade> orders = request.getOrders();
            List<String> outerBizNos = new ArrayList<String>();
            List<TradeRes> trades = new ArrayList<TradeRes>();
            for (CreateTrade order : orders) {
                validateParam(order);
                outerBizNos.add(order.getOuter_biz_no());
                if (!CollectionUtils.isEmpty(order.getRoyalties())) {
                    for (Royalty royalty : order.getRoyalties()) {
                        validateParam(royalty);
                    }
                }
                if (!CollectionUtils.isEmpty(order.getExchanges())) {
                    for (Exchange exchange : order.getExchanges()) {
                        validateParam(exchange);
                    }
                }
                // 业务执行
                BaseResult<String> result = getTradeProcessFacade().create(
                    buildTradeRequest(request, order));
                if (!result.isSuccess()) {
                    throw new BizException(result.getErrorCode(), result.getErrorMsg());
                }
                TradeRes trade = new TradeRes();
                trade.setOuter_biz_no(order.getOuter_biz_no());
                trade.setTotal_amount(order.getTotal_amount());
                trade.setTrade_no(result.getData());
                trade.setTradeState(TradeState.UNPAY.getCode());
                trades.add(trade);
            }

            // 构建返回结果
            response.setTrades(trades);
            response.setIs_success('1');
            return response;
        } catch (IllegalArgumentException ae) {
            logger.warn("【创建担保交易】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (BizException e) {
            logger.error("【创建担保交易】失败，jsonRequest=" + jsonRequest, e);
            return buildFail(e.getErrorCode(), e.getErrorMsg());
        } catch (Exception e) {
            logger.error("【创建担保交易】系统异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }

    /* 构建交易凭证 */
    private com.hofon.trade.facade.request.CreateTradeRequest buildTradeRequest(CreateTradeRequest request,
                                                                                CreateTrade order) {
        com.hofon.trade.facade.request.CreateTradeRequest createRequest = new com.hofon.trade.facade.request.CreateTradeRequest();
        TradeType tradeType = TradeType.getEnum(order.getTrade_type());
        createRequest.setBizCode(tradeType == TradeType.ENSURE ? BizCode.ENSURE.getCode()
            : BizCode.DIRECT.getCode());
        createRequest.setBuyerId(request.getPayer_member_id());
        createRequest.setExchanges(buildExchange(order.getExchanges()));
        createRequest.setMemo(request.getMemo());
        Merchant merchant = getMerchant(request.getMerchant_id());
        createRequest.setMerchantId(merchant.getMerchantId());
        createRequest.setMerchantName(merchant.getMerchantName());
        createRequest.setOuterBizNo(order.getOuter_biz_no());
        createRequest.setSellerId(order.getPayee_member_id());
        createRequest.setSplitParties(buildSplit(order.getRoyalties()));
        createRequest.setTradeAmount(order.getTotal_amount());
        createRequest.setTradeGoods(buildGoods(order.getProducts()));
        createRequest.setGmtInvalid(DateUtil.addDays(new Date(), 7));// 默认七天过期
        return createRequest;
    }

    private List<com.zhuking.service.domain.Exchange> buildExchange(List<Exchange> exchanges) {
        if (CollectionUtils.isEmpty(exchanges)) {
            return null;
        }
        List<com.zhuking.service.domain.Exchange> exList = new ArrayList<>();
        for (Exchange ex : exchanges) {
            validateParam(ex);
            com.zhuking.service.domain.Exchange target = new com.zhuking.service.domain.Exchange();
            BeanUtils.copyProperties(ex, target);
            exList.add(target);
        }
        return exList;
    }

    private List<SplitParty> buildSplit(List<Royalty> royalties) {
        if (CollectionUtils.isEmpty(royalties)) {
            return null;
        }
        List<SplitParty> splitList = new ArrayList<>();
        for (Royalty royalty : royalties) {
            validateParam(royalty);
            SplitParty split = new SplitParty();
            split.setAmount(royalty.getAmount());
            split.setPayerId(royalty.getPayer_member_id());
            split.setPayeeId(royalty.getPayee_member_id());
            split.setSplitTag(SplitTag.PROFIT.getCode());
            split.setSplitSource(royalty.getSplit_source());
            split.setSplitRate(royalty.getSplit_rate());
        }
        return splitList;
    }

    private List<TradeGoods> buildGoods(List<Product> products) {
        if (CollectionUtils.isEmpty(products)) {
            return null;
        }
        List<TradeGoods> goodList = new ArrayList<>();
        for (Product prod : products) {
            validateParam(prod);
            TradeGoods target = new TradeGoods();
            BeanUtils.copyProperties(prod, target);
            goodList.add(target);
        }
        return goodList;
    }

}
