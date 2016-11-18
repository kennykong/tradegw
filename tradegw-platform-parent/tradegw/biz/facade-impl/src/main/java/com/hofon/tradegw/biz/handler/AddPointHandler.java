/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hofon.member.common.model.MemberBasicInfo;
import com.hofon.trade.facade.request.AddPointRequest;
import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.model.TradegwResultCode;
import com.hofon.tradegw.facade.request.AddPointsRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.zhuking.biz.common.domain.CouponType;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;

/**
 * 增加积分-处理器
 * @author xilu.tong
 * @version $Id: AddPointHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "add_points")
public class AddPointHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(AddPointHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            // 参数转换
            AddPointsRequest request = JsonUtil.json2Obj(jsonRequest, AddPointsRequest.class);
            // 参数校验
            validateParam(request);
            // 登录验证
            MemberBasicInfo memberInfo = getMemberBasicInfoFromCache(request.getToken());
            if (memberInfo == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            // 业务执行
            AddPointRequest addRequest = new AddPointRequest();
            addRequest.setCount(request.getCount());
            addRequest.setCouponType(CouponType.POINTS);
            addRequest.setAccountNo(memberInfo.getAccountNo());
            BaseResult<Long> result = getTradeProcessFacade().addPoint(addRequest);
            if (result.isSuccess()) {
                return new BasePublicResponse();
            } else {
                return buildFail(result.getErrorCode(), result.getErrorMsg());
            }
        } catch (IllegalArgumentException ae) {
            logger.warn("【增加积分】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("【增加积分】系统异常异常，jsonRequest=" + jsonRequest, e);
            return buildResponse(TradegwResultCode.SYSTEM_ERROR);
        }
    }
}
