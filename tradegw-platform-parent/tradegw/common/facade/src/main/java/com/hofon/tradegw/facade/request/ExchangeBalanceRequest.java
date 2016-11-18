/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.hofon.tradegw.facade.model.Exchange;

/**
 * 余额兑换请求
 * @author xilu.tong
 * @version $Id: ExchangeBalanceRequest.java, v0.1 2015年11月27日 下午1:04:10 xilu.tong Exp $
 */
public class ExchangeBalanceRequest extends BasePublicRequest {

    /** SID */
    private static final long serialVersionUID = -3202005981758849718L;

    /** 会员ID */
    @NotBlank(message = "会员ID为空")
    private String            member_id;

    /** 目前仅支持积分兑换 */
    @NotNull(message = "兑换券不能为空")
    private Exchange          exchange;

    /**
     * Getter method for property <tt>member_id</tt>.
     * 
     * @return property value of member_id
     */
    public String getMember_id() {
        return member_id;
    }

    /**
     * Setter method for property <tt>member_id</tt>.
     * 
     * @param member_id value to be assigned to property member_id
     */
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    /**
     * Getter method for property <tt>exchange</tt>.
     * 
     * @return property value of exchange
     */
    public Exchange getExchange() {
        return exchange;
    }

    /**
     * Setter method for property <tt>exchange</tt>.
     * 
     * @param exchange value to be assigned to property exchange
     */
    public void setExchange(Exchange exchange) {
        this.exchange = exchange;
    }

}
