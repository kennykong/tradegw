/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.model.TradegwResultCode;
import com.hofon.tradegw.facade.request.ChangeTradeAmountRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.ChangeTradeAmountResponse;
import com.zhuking.biz.common.domain.BizCode;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;
import com.zhuking.common.util.money.Money;

/**
 * 修改交易金额-处理器
 * @author xilu.tong
 * @version $Id: ChangeTradeAmountHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "change_trade_amount")
public class ChangeTradeAmountHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(ChangeTradeAmountHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            ChangeTradeAmountResponse response = new ChangeTradeAmountResponse();
            // 参数转换
            ChangeTradeAmountRequest request = JsonUtil.json2Obj(jsonRequest,
                ChangeTradeAmountRequest.class);
            // 参数校验
            validateParam(request);
            // 登录验证
            if (getMemberBasicInfoFromCache(request.getToken()) == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            Money tradeAmount = new Money(request.getTrade_amount());
            if (!tradeAmount.greaterThan(new Money(0, 0))) {
                return buildResponse(TradegwResultCode.AMOUNT_NOT_INVALID);
            }
            // 业务执行
            String tradeNo = request.getTrade_no();
            com.hofon.trade.facade.request.ChangeTradeAmountRequest changeRequest = new com.hofon.trade.facade.request.ChangeTradeAmountRequest();
            changeRequest.setBizCode(BizCode.CHANGE_TRADE_AMOUNT);
            changeRequest.setTradeAmount(tradeAmount);
            changeRequest.setSynRatio(true);
            changeRequest.setTradeNo(tradeNo);
            BaseResult<Boolean> result = getTradeProcessFacade().editTradeAmount(changeRequest);
            if (result.isSuccess() && result.getData() == true) {
                response.setIs_success('1');
                response.setTrade_no(request.getTrade_no());
                response.setTrade_amount(request.getTrade_amount());
                return response;
            } else {
                return buildFail(result.getErrorCode(), result.getErrorMsg());
            }
        } catch (IllegalArgumentException ae) {
            logger.warn("【修改交易金额】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("【修改交易金额】系统异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }
}
