/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hofon.securitycenter.auc.facade.AuthQueryFacade;
import com.hofon.securitycenter.auc.facade.ZkSignFacade;
import com.hofon.securitycenter.auc.request.AuthQueryRequest;
import com.hofon.securitycenter.auc.request.CheckSignRequest;
import com.hofon.tradegw.biz.ITradegwService;
import com.hofon.tradegw.biz.SpringContextUtil;
import com.hofon.tradegw.facade.model.TradegwResultCode;
import com.hofon.tradegw.facade.response.BasePublicResponse;
import com.zhuking.biz.common.domain.SecretType;
import com.zhuking.common.domain.BaseResult;
import com.zhuking.common.lang.StringUtil;
import com.zhuking.common.util.JsonUtil;

/**
 * 交易网关服务
 * @author zhuking
 * @version $Id: TradeGwController.java, v0.1 2015年12月2日 下午7:29:24 xilu.tong Exp $
 */
@Controller
public class TradeGwController {

    private static final Logger logger = LoggerFactory.getLogger(TradeGwController.class);

    @Resource(name = "contextUtil")
    private SpringContextUtil   contextUtil;

    @Resource(name = "authQueryFacade")
    private AuthQueryFacade     authQueryFacade;

    @Resource(name = "zkSignFacade")
    private ZkSignFacade        zkSignFacade;

    /**
     * 网关服务接口
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "tradegw.json", method = RequestMethod.POST)
    @ResponseBody
    public BasePublicResponse doJson(HttpServletRequest request) {
        try {
            logger.info("收单网关接收到请求：{}", JsonUtil.obj2Json(request.getParameterMap()));

            String json_req = request.getParameter("json_req");
            String service = request.getParameter("service");
            String pid = request.getParameter("pid");
            String sign = request.getParameter("sign");
            String sign_type = request.getParameter("sign_type");
            String input_charset = request.getParameter("input_charset");
            // 接口鉴权
            if (!auth(service, pid)) {
                return new BasePublicResponse(TradegwResultCode.NOT_AUTH);
            }
            // 参数验签
            if (!checkSign(json_req, pid, service, sign, sign_type, input_charset)) {
                return new BasePublicResponse(TradegwResultCode.VERIFY_SIGN_FAIL);
            }
            // 业务处理
            ITradegwService tradegwService = (ITradegwService) contextUtil
                .getServiceByAnnoName(service);
            return tradegwService.process(json_req);
        } catch (Exception e) {
            logger.error("【收单网关】系统异常", e);
            return new BasePublicResponse(TradegwResultCode.SYSTEM_ERROR);
        }

    }

    private boolean auth(String service, String pid) {
        if (StringUtil.isAnyBlank(service, pid)) {
            return false;
        }
        AuthQueryRequest req = new AuthQueryRequest();
        req.setPid(pid);
        req.setService(service);
        BaseResult<Boolean> result = authQueryFacade.isAuth(req);
        if (result.isSuccess() && result.getData() == true) {
            return true;
        } else {
            logger.warn("【调用收单网关接口】鉴权失败：AuthQueryRequest=" + req + " ;result=" + result);
            return false;
        }
    }

    private boolean checkSign(String json_req, String pid, String service, String sign,
                              String sign_type, String input_charset) {
        CheckSignRequest req = new CheckSignRequest();
        req.setInput_charset(input_charset);
        req.setJson_req(json_req);
        req.setPid(pid);
        req.setService(service);
        req.setSign(sign);
        req.setSign_type(StringUtil.isBlank(sign_type) ? SecretType.RSA : SecretType
            .parse(sign_type));
        req.setType(1);
        BaseResult<Boolean> result = zkSignFacade.check(req);
        if (result.isSuccess() && result.getData() == true) {
            return true;
        } else {
            logger.warn("【调用收单网关接口】验签失败：request=" + req + " ;result=" + result);
            return false;
        }
    }
}
