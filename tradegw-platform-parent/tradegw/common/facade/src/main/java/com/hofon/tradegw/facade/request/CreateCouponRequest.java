/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 发送红包请求
 * @author xilu.tong
 * @version $Id: CreateCouponRequest.java, v0.1 2015年11月27日 上午11:45:25 xilu.tong Exp $
 */
public class CreateCouponRequest extends BasePublicRequest {

    /** SID */
    private static final long serialVersionUID = -3717586668383256440L;

    /** 发送人 */
    @NotBlank(message = "付款方不能为空")
    private String            sender_member_id;

    /** 接收人 */
    @NotNull(message = "收款方不能为空")
    private Set<String>       receiver_member_id;

    /** 红包总金额 */
    @NotNull(message = "红包总金额不能为空")
    private BigDecimal        total_amount;

    /** 红包过期截止时间，默认7天 */
    private Date              expire_time;

    /** 备注 */
    private String            memo;

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
