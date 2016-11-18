/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.model.TradeState;
import com.hofon.tradegw.facade.request.CancelTradeRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.CancelTradeResponse;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;

/**
 * 取消交易-处理器
 * @author xilu.tong
 * @version $Id: CancelTradeHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "cancel_trade")
public class CancelTradeHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(CancelTradeHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            CancelTradeResponse response = new CancelTradeResponse();
            // 参数转换
            CancelTradeRequest request = JsonUtil.json2Obj(jsonRequest, CancelTradeRequest.class);
            // 参数校验
            validateParam(request);
            // 登录验证
            if (getMemberBasicInfoFromCache(request.getToken()) == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            // 业务执行
            com.hofon.trade.facade.request.CancelTradeRequest cancelRequest = new com.hofon.trade.facade.request.CancelTradeRequest();
            BaseResult<Boolean> result = getTradeProcessFacade().cancel(cancelRequest);
            if (result.isSuccess() && result.getData() == true) {
                response.setIs_success('1');
                response.setTrade_no(request.getTrade_no());
                response.setTrade_state(TradeState.CANCEL.getCode());
                return response;
            } else {
                return buildFail(result.getErrorCode(), result.getErrorMsg());
            }
        } catch (IllegalArgumentException ae) {
            logger.warn("【取消交易】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("【取消交易】系统异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }

}
