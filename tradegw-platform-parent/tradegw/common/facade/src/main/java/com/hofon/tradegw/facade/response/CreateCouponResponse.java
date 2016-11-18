/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 发送红包返回对象
 * @author xilu.tong
 * @version $Id: CreateCouponResponse.java, v0.1 2015年11月27日 下午2:32:50 xilu.tong Exp $
 */
public class CreateCouponResponse extends BasePublicResponse {

    /** SID  */
    private static final long serialVersionUID = 5149594434310932004L;

    /** 交易流水号 */
    private String            trade_no;

    /** 发送人 */
    private String            sender_member_id;

    /** 接收人 */
    private Set<String>       receiver_member_id;

    /** 红包总金额 */
    private BigDecimal        total_amount;

    /** 红包过期截止时间 */
    private Date              expire_time;

    public CreateCouponResponse() {
        this.setIs_success('1');
    }

    public CreateCouponResponse(TradegwResultCode resultCode) {
        this.setIs_success('0');
        this.setError_code(resultCode.getCode());
        this.setError_msg(resultCode.getMsg());
    }

    public CreateCouponResponse(String code, String msg) {
        this.setIs_success('0');
        this.setError_code(code);
        this.setError_msg(msg);
    }

    /**
     * Getter method for property <tt>trade_no</tt>.
     * 
     * @return property value of trade_no
     */
    public String getTrade_no() {
        return trade_no;
    }

    /**
     * Setter method for property <tt>trade_no</tt>.
     * 
     * @param trade_no value to be assigned to property trade_no
     */
    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    /**
     * Getter method for property <tt>sender_member_id</tt>.
     * 
     * @return property value of sender_member_id
     */
    public String getSender_member_id() {
        return sender_member_id;
    }

    /**
     * Setter method for property <tt>sender_member_id</tt>.
     * 
     * @param sender_member_id value to be assigned to property sender_member_id
     */
    public void setSender_member_id(String sender_member_id) {
        this.sender_member_id = sender_member_id;
    }

    /**
     * Getter method for property <tt>receiver_member_id</tt>.
     * 
     * @return property value of receiver_member_id
     */
    public Set<String> getReceiver_member_id() {
        return receiver_member_id;
    }

    /**
     * Setter method for property <tt>receiver_member_id</tt>.
     * 
     * @param receiver_member_id value to be assigned to property receiver_member_id
     */
    public void setReceiver_member_id(Set<String> receiver_member_id) {
        this.receiver_member_id = receiver_member_id;
    }

    /**
     * Getter method for property <tt>total_amount</tt>.
     * 
     * @return property value of total_amount
     */
    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    /**
     * Setter method for property <tt>total_amount</tt>.
     * 
     * @param total_amount value to be assigned to property total_amount
     */
    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * Getter method for property <tt>expire_time</tt>.
     * 
     * @return property value of expire_time
     */
    public Date getExpire_time() {
        return expire_time;
    }

    /**
     * Setter method for property <tt>expire_time</tt>.
     * 
     * @param expire_time value to be assigned to property expire_time
     */
    public void setExpire_time(Date expire_time) {
        this.expire_time = expire_time;
    }

}
