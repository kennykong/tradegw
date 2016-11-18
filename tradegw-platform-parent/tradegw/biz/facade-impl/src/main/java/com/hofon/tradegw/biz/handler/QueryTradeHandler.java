/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import com.hofon.trade.facade.model.BaseTradeOrder;
import com.hofon.trade.facade.request.BatchQueryTradeRequest;
import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.model.TradeOrder;
import com.hofon.tradegw.facade.request.QueryTradeRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.QueryTradeResponse;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.domain.PageList;
import com.zhuking.common.util.JsonUtil;

/**
 * 交易查询-处理器
 * @author xilu.tong
 * @version $Id: QueryTradeHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "query_trade")
public class QueryTradeHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(QueryTradeHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            // 参数转换
            QueryTradeRequest request = JsonUtil.json2Obj(jsonRequest, QueryTradeRequest.class);
            // 参数校验
            validateParam(request);
            // 业务执行
            BatchQueryTradeRequest batchQuery = new BatchQueryTradeRequest();
            batchQuery.setTradeNos(request.getTrade_no());
            batchQuery.setNeedQueryAll(true);
            batchQuery.setStartTime(request.getStartTime());
            batchQuery.setEndTime(request.getEndTime());
            BaseResult<PageList<BaseTradeOrder>> queryResult = getTradeQueryFacade().queryList(
                batchQuery);
            if (!queryResult.isSuccess()) {
                return buildFail(queryResult.getErrorCode(), queryResult.getErrorMsg());
            }
            return convertResponse(queryResult.getData());
        } catch (IllegalArgumentException ae) {
            logger.warn("【交易查询】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("【交易查询】系统异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }

    private QueryTradeResponse convertResponse(PageList<BaseTradeOrder> tradeList) {
        QueryTradeResponse response = new QueryTradeResponse();
        if (tradeList == null || CollectionUtils.isEmpty(tradeList.getDatalist())) {
            return response;
        }
        List<TradeOrder> tradeRes = new ArrayList<>();
        for (BaseTradeOrder trade : tradeList.getDatalist()) {
            TradeOrder target = new TradeOrder();
            target.setCoupon_parameters(trade.getCouponParameters());
            target.setGmt_create(trade.getGmtCreate());
            target.setGmt_paid(trade.getGmtPaid());
            target.setOuter_biz_no(trade.getOuterBizNo());
            target.setPay_pode(trade.getPayMode());
            target.setPayee_member_id(trade.getSellerId());
            target.setPayer_member_id(trade.getBuyerId());
            target.setStatus(trade.getStatus());
            target.setTrade_amount(trade.getTradeAmount());
            target.setTrade_no(trade.getTradeNo());
            tradeRes.add(target);
        }
        return response;
    }
}
