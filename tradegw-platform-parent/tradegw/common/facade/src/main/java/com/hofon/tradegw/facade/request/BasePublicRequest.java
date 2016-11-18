/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import org.hibernate.validator.constraints.NotBlank;

import com.hofon.tradegw.facade.model.BaseModel;

/**
 * 公共请求参数
 * @author xilu.tong
 * @version $Id: BaseTradeRequest.java, v0.1 2015年11月27日 上午10:55:36 xilu.tong Exp $
 */
public class BasePublicRequest extends BaseModel {

    /** SID */
    private static final long serialVersionUID = 7507196252426927290L;

    /** 访问token */
    @NotBlank(message = "访问token不能为空")
    private String            token;

    /** 备注 */
    private String            memo;

    /**
     * Getter method for property <tt>token</tt>.
     * 
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for property <tt>token</tt>.
     * 
     * @param token value to be assigned to property token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter method for property <tt>memo</tt>.
     * 
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property <tt>memo</tt>.
     * 
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

}
