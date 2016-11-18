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
import com.hofon.tradegw.facade.request.SendGoodsRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.SendGoodsResponse;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;

/**
 * 发货通知-处理器
 * @author xilu.tong
 * @version $Id: SendGoodsHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "send_goods")
public class SendGoodsHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(SendGoodsHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            SendGoodsResponse response = new SendGoodsResponse();
            // 参数转换
            SendGoodsRequest request = JsonUtil.json2Obj(jsonRequest, SendGoodsRequest.class);
            // 参数校验
            validateParam(request);
            // 业务执行
            BaseResult<String> result = getTradeProcessFacade().confirm(request.getTrade_no());
            if (result.isSuccess()) {
                response.setIs_success('1');
                response.setTrade_no(request.getTrade_no());
                response.setOuter_biz_no(result.getData());
                response.setTradeState(TradeState.CONFIRM.getCode());
                return response;
            } else {
                return buildFail(result.getErrorCode(), result.getErrorMsg());
            }
        } catch (IllegalArgumentException ae) {
            logger.warn("【发货通知】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("【发货通知】处理异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }
}
