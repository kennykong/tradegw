/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hofon.member.common.model.MemberBasicInfo;
import com.hofon.trade.facade.request.RefundTradeRequest;
import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.request.CreateRefundRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.CreateRefundResponse;
import com.zhuking.biz.common.domain.RefundState;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;

/**
 * 创建交易退款-处理器
 * @author xilu.tong
 * @version $Id: CreateRefundHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "create_refund")
public class CreateRefundHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(CreateRefundHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            // 参数转换
            CreateRefundRequest request = JsonUtil.json2Obj(jsonRequest, CreateRefundRequest.class);
            // 参数校验
            validateParam(request);
            // 登录验证
            MemberBasicInfo memberInfo = getMemberBasicInfoFromCache(request.getToken());
            if (memberInfo == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            // 业务执行
            RefundTradeRequest refundRequest = new RefundTradeRequest();
            refundRequest.setTradeNo(request.getTrade_no());
            refundRequest.setRefundReason(request.getRefund_reason());
            refundRequest.setRefundPayAmount(request.getRefund_amount());
            BaseResult<String> refundResult = getTradeProcessFacade().refund(refundRequest);
            if (!refundResult.isSuccess()) {
                buildFail(refundResult.getErrorCode(), refundResult.getErrorMsg());
            }
            // 构造返回对象
            CreateRefundResponse response = new CreateRefundResponse();
            response.setIs_success('1');
            response.setRefundState(RefundState.SUCCESS.getCode());
            return response;
        } catch (IllegalArgumentException ae) {
            logger.warn("交易退款参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("交易退款异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }
}
