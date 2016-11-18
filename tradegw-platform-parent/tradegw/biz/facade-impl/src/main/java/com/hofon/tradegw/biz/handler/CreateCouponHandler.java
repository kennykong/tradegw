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
import com.hofon.tradegw.facade.request.CreateCouponRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.CreateCouponResponse;
import com.zhuking.biz.common.domain.BizCode;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;
import com.zhuking.common.util.money.Money;

/**
 * 发送红包-处理器
 * @author xilu.tong
 * @version $Id: CreateCouponHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "create_coupon")
public class CreateCouponHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(CreateCouponHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            // 参数转换
            CreateCouponRequest request = JsonUtil.json2Obj(jsonRequest, CreateCouponRequest.class);

            // 参数校验
            validateParam(request);
            // 登录验证
            MemberBasicInfo memberInfo = getMemberBasicInfoFromCache(request.getToken());
            if (memberInfo == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            // 业务执行
            com.hofon.trade.facade.request.CreateCouponRequest couponRequest = new com.hofon.trade.facade.request.CreateCouponRequest();
            couponRequest.setBizCode(BizCode.SEND_COUPON);
            couponRequest.setExpireTime(request.getExpire_time());
            couponRequest.setMemo(request.getMemo());
            couponRequest.setReceiverMemberId(request.getReceiver_member_id());
            couponRequest.setSenderMemberId(request.getSender_member_id());
            couponRequest.setTotalAmount(new Money(request.getTotal_amount()));
            couponRequest.setTradeNo(getNoGeneratorFacade().genTradeNo(1).getData().get(0));
            BaseResult<String> result = getTradeProcessFacade().sendCoupon(couponRequest);
            // 构建返回结果
            return buildResponse(result, request);
        } catch (IllegalArgumentException ae) {
            logger.warn("发送红包参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("发送红包异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }

    private BasePublicResponse buildResponse(BaseResult<String> result, CreateCouponRequest request) {
        CreateCouponResponse response = new CreateCouponResponse();
        response.setMemo(null);
        response.setReceiver_member_id(request.getReceiver_member_id());
        response.setSender_member_id(request.getSender_member_id());
        response.setTotal_amount(request.getTotal_amount());
        response.setExpire_time(request.getExpire_time());
        if (result.isSuccess()) {
            response.setIs_success('1');
            response.setTrade_no(result.getData());
        } else {
            response.setIs_success('1');
            response.setError_code(result.getErrorCode());
            response.setError_msg(result.getErrorMsg());
        }
        return response;
    }
}
