/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 交易订单对象
 * @author hofon
 * @version $Id: TradeOrder.java, v0.1 2016年4月1日 下午4:12:49 hofon Exp $
 */
public class TradeOrder implements Serializable {

    /** SID */
    private static final long serialVersionUID = -1688312461495965188L;

    /** 外部订单号 */
    private String            outer_biz_no;

    /** 交易流水号 */
    private String            trade_no;

    /** 付款方 */
    private String            payer_member_id;

    /** 收款方 */
    private String            payee_member_id;

    /** 抵扣参数集 */
    private String            coupon_parameters;

    /** 交易金额 */
    private BigDecimal        trade_amount;

    /** 交易状态 */
    private String            status;

    /** 支付方式 */
    private String            pay_pode;

    /** 付款时间 */
    private Date              gmt_paid;

    /** 创建时间 */
    private Date              gmt_create;

    /**
     * Getter method for property <tt>outer_biz_no</tt>.
     * 
     * @return property value of outer_biz_no
     */
    public String getOuter_biz_no() {
        return outer_biz_no;
    }

    /**
     * Setter method for property <tt>outer_biz_no</tt>.
     * 
     * @param outer_biz_no value to be assigned to property outer_biz_no
     */
    public void setOuter_biz_no(String outer_biz_no) {
        this.outer_biz_no = outer_biz_no;
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
     * Getter method for property <tt>payer_member_id</tt>.
     * 
     * @return property value of payer_member_id
     */
    public String getPayer_member_id() {
        return payer_member_id;
    }

    /**
     * Setter method for property <tt>payer_member_id</tt>.
     * 
     * @param payer_member_id value to be assigned to property payer_member_id
     */
    public void setPayer_member_id(String payer_member_id) {
        this.payer_member_id = payer_member_id;
    }

    /**
     * Getter method for property <tt>payee_member_id</tt>.
     * 
     * @return property value of payee_member_id
     */
    public String getPayee_member_id() {
        return payee_member_id;
    }

    /**
     * Setter method for property <tt>payee_member_id</tt>.
     * 
     * @param payee_member_id value to be assigned to property payee_member_id
     */
    public void setPayee_member_id(String payee_member_id) {
        this.payee_member_id = payee_member_id;
    }

    /**
     * Getter method for property <tt>coupon_parameters</tt>.
     * 
     * @return property value of coupon_parameters
     */
    public String getCoupon_parameters() {
        return coupon_parameters;
    }

    /**
     * Setter method for property <tt>coupon_parameters</tt>.
     * 
     * @param coupon_parameters value to be assigned to property coupon_parameters
     */
    public void setCoupon_parameters(String coupon_parameters) {
        this.coupon_parameters = coupon_parameters;
    }

    /**
     * Getter method for property <tt>trade_amount</tt>.
     * 
     * @return property value of trade_amount
     */
    public BigDecimal getTrade_amount() {
        return trade_amount;
    }

    /**
     * Setter method for property <tt>trade_amount</tt>.
     * 
     * @param trade_amount value to be assigned to property trade_amount
     */
    public void setTrade_amount(BigDecimal trade_amount) {
        this.trade_amount = trade_amount;
    }

    /**
     * Getter method for property <tt>status</tt>.
     * 
     * @return property value of status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for property <tt>status</tt>.
     * 
     * @param status value to be assigned to property status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for property <tt>pay_pode</tt>.
     * 
     * @return property value of pay_pode
     */
    public String getPay_pode() {
        return pay_pode;
    }

    /**
     * Setter method for property <tt>pay_pode</tt>.
     * 
     * @param pay_pode value to be assigned to property pay_pode
     */
    public void setPay_pode(String pay_pode) {
        this.pay_pode = pay_pode;
    }

    /**
     * Getter method for property <tt>gmt_paid</tt>.
     * 
     * @return property value of gmt_paid
     */
    public Date getGmt_paid() {
        return gmt_paid;
    }

    /**
     * Setter method for property <tt>gmt_paid</tt>.
     * 
     * @param gmt_paid value to be assigned to property gmt_paid
     */
    public void setGmt_paid(Date gmt_paid) {
        this.gmt_paid = gmt_paid;
    }

    /**
     * Getter method for property <tt>gmt_create</tt>.
     * 
     * @return property value of gmt_create
     */
    public Date getGmt_create() {
        return gmt_create;
    }

    /**
     * Setter method for property <tt>gmt_create</tt>.
     * 
     * @param gmt_create value to be assigned to property gmt_create
     */
    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }
}
