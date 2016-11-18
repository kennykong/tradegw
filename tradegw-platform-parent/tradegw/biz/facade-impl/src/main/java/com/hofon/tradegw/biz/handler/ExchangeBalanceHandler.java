/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.hofon.member.common.model.MemberBasicInfo;
import com.hofon.tradegw.biz.ServiceRoute;
import com.hofon.tradegw.biz.TradegwService;
import com.hofon.tradegw.facade.model.Exchange;
import com.hofon.tradegw.facade.request.ExchangeBalanceRequest;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.hofon.tradegw.facade.response.ExchangeBalanceResponse;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.domain.BaseResultCode;
import com.zhuking.common.util.JsonUtil;

/**
 * 余额兑换-处理器
 * @author xilu.tong
 * @version $Id: ExchangeBalanceHandler.java, v0.1 2015年11月27日 下午4:32:24 xilu.tong Exp $
 */
@ServiceRoute(name = "exchange_balance")
public class ExchangeBalanceHandler extends TradegwService {

    private static final Logger logger = LoggerFactory.getLogger(ExchangeBalanceHandler.class);

    /**
     * @see com.hofon.tradegw.biz.TradegwService#process(java.lang.String)
     */
    @Override
    public BasePublicResponse process(String jsonRequest) {
        try {
            // 参数转换
            ExchangeBalanceRequest request = JsonUtil.json2Obj(jsonRequest,
                ExchangeBalanceRequest.class);
            // 参数校验
            validateParam(request);
            // 登录验证
            MemberBasicInfo memberInfo = getMemberBasicInfoFromCache(request.getToken());
            if (memberInfo == null) {
                return buildFail(BaseResultCode.MEMBER_NOT_LOGIN.getCode(),
                    BaseResultCode.MEMBER_NOT_LOGIN.getMsg());
            }
            // 业务执行
            Exchange source = request.getExchange();
            com.zhuking.service.domain.Exchange target = new com.zhuking.service.domain.Exchange();
            BeanUtils.copyProperties(source, target);
            com.hofon.trade.facade.request.ExchangeBalanceRequest exchangeRequest = new com.hofon.trade.facade.request.ExchangeBalanceRequest();
            exchangeRequest.setAccountNo(memberInfo.getAccountNo());
            exchangeRequest.setExchange(target);
            BaseResult<Boolean> result = getTradeProcessFacade().exchangeBalance(exchangeRequest);
            if (result.isSuccess() && result.getData() == true) {
                return convertResponse(request);
            } else {
                logger.warn("【余额兑换】失败，jsonRequest=" + jsonRequest + " ;result=" + result);
                return buildFail(result.getErrorCode(), result.getErrorMsg());
            }
        } catch (IllegalArgumentException ae) {
            logger.warn("【余额兑换】参数校验不通过，jsonRequest=" + jsonRequest, ae);
            return buildFail(BaseResultCode.PARAM_INVALID.getCode(), ae.getMessage());
        } catch (Exception e) {
            logger.error("【余额兑换】系统异常，jsonRequest=" + jsonRequest, e);
            return buildSystemError();
        }
    }

    private ExchangeBalanceResponse convertResponse(ExchangeBalanceRequest request) {
        ExchangeBalanceResponse response = new ExchangeBalanceResponse();
        response.setIs_success('1');
        response.setMember_id(request.getMember_id());
        response.setMemo("");
        response.setExchange(request.getExchange());
        return response;
    }
}
