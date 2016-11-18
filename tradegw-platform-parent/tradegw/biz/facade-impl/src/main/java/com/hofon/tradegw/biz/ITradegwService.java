/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz;

import com.hofon.tradegw.facade.response.BasePublicResponse;

/**
 * 收单网关接口
 * @author xilu.tong
 * @version $Id: ITradegwService.java, v0.1 2015年11月27日 下午4:07:47 xilu.tong Exp $
 */
public interface ITradegwService {

    /**
     * 业务执行
     * <pre>入参、出参均不包含签名及签名类型</pre>
     * @param jsonRequest 接口入参对象JSON格式
     * @return 
     */
    public BasePublicResponse process(String jsonRequest);

}
