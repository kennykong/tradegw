/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hofon.member.common.model.MemberBasicInfo;
import com.hofon.trade.facade.model.BaseTradeOrder;
import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.model.TradegwResultCode;
import com.hofon.tradegw.facade.request.ConfirmCouponRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.ConfirmCouponResponse;
import com.zhuking.biz.common.domain.BizCode;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;

/**
 * 接收红包-处理器
 * @author xilu.tong
 * @version $Id: ConfirmCouponHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "process_coupon")
public class ConfirmCouponHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(ConfirmCouponHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            ConfirmCouponResponse response = new ConfirmCouponResponse();
            // 参数转换
            ConfirmCouponRequest request = JsonUtil.json2Obj(jsonRequest,
                ConfirmCouponRequest.class);
            String tradeNo = request.getTrade_no();
            // 参数校验
            validateParam(request);
            // 登录验证
            MemberBasicInfo memberInfo = getMemberBasicInfoFromCache(request.getToken());
            if (memberInfo == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            BaseResult<BaseTradeOrder> tradeResult = getTradeQueryFacade().getByTradeNo(tradeNo);
            if (tradeResult.getData() == null) {
                return buildResponse(TradegwResultCode.TRADE_NOT_EXIST);
            }
            // 业务执行
            int operateType = Integer.parseInt(request.getOperate_type());
            com.hofon.trade.facade.request.ConfirmCouponRequest comfirmRequest = new com.hofon.trade.facade.request.ConfirmCouponRequest();
            comfirmRequest.setReceiverAccountNo(memberInfo.getAccountNo());
            comfirmRequest.setTradeNo(request.getTrade_no());
            if (operateType == 0) {
                comfirmRequest.setBizCode(BizCode.RE_COUPON);
            } else if (operateType == 1) {
                comfirmRequest.setBizCode(BizCode.RECEIVE_COUPON);
            } else {
                return buildResponse(TradegwResultCode.PARAM_INVALID);
            }
            BaseResult<Boolean> result = getTradeProcessFacade().processCoupon(comfirmRequest);
            if (result.isSuccess() && result.getData() == true) {
                response.setIs_success('1');
                response.setTrade_no(request.getTrade_no());
                response.setReceiver_member_id(request.getReceiver_member_id());
                response.setOperate_type(request.getOperate_type());
                return response;
            } else {
                return buildFail(result.getErrorCode(), result.getErrorMsg());
            }
        } catch (IllegalArgumentException ae) {
            logger.warn("【接收红包】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("【接收红包】系统异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }
}
