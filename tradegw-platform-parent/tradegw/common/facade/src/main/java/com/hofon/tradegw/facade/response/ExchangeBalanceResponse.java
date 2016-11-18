/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import com.hofon.tradegw.facade.model.Exchange;
import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 余额兑换返回对象
 * @author xilu.tong
 * @version $Id: ExchangeBalanceResponse.java, v0.1 2015年11月27日 下午2:33:36 xilu.tong Exp $
 */
public class ExchangeBalanceResponse extends BasePublicResponse {

    /** SID */
    private static final long serialVersionUID = 8205212608218965242L;

    /** 会员ID */
    private String            member_id;

    /** 兑换对象 */
    private Exchange          exchange;

    public ExchangeBalanceResponse() {
        this.setIs_success('1');
    }

    public ExchangeBalanceResponse(TradegwResultCode resultCode) {
        this.setIs_success('0');
        this.setError_code(resultCode.getCode());
        this.setError_msg(resultCode.getMsg());
    }

    public ExchangeBalanceResponse(String code, String msg) {
        this.setIs_success('0');
        this.setError_code(code);
        this.setError_msg(msg);
    }

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
