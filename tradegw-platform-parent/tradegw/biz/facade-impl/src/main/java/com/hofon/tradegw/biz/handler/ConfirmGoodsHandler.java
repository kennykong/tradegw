/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hofon.member.common.model.MemberBasicInfo;
import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.model.TradeState;
import com.hofon.tradegw.facade.request.ConfirmGoodsRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.ConfirmGoodsResponse;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;

/**
 * 确认收货-处理器
 * @author xilu.tong
 * @version $Id: ConfirmGoodsHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "confirm_goods")
public class ConfirmGoodsHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(ConfirmGoodsHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            ConfirmGoodsResponse response = new ConfirmGoodsResponse();
            // 参数转换
            ConfirmGoodsRequest request = JsonUtil.json2Obj(jsonRequest, ConfirmGoodsRequest.class);
            // 参数校验
            validateParam(request);
            // 登录验证
            MemberBasicInfo memberInfo = getMemberBasicInfoFromCache(request.getToken());
            if (memberInfo == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            String tradeNo = request.getTrade_no();
            // 业务执行
            BaseResult<String> result = getTradeProcessFacade().confirm(tradeNo);
            if (result.isSuccess()) {
                response.setIs_success('1');
                response.setTrade_no(request.getTrade_no());
                response.setOuter_biz_no(result.getData());
                response.setTradeState(TradeState.FINISH.getCode());
                return response;
            } else {
                return buildFail(result.getErrorCode(), result.getErrorMsg());
            }
        } catch (IllegalArgumentException ae) {
            logger.warn("【确认收货】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("【确认收货】系统异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }
}
