/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 分润对象
 * @author xilu.tong
 * @version $Id: Royalty.java, v0.1 2015年11月27日 下午1:38:48 xilu.tong Exp $
 */
public class Royalty extends BaseModel {

    /** SID */
    private static final long serialVersionUID = -6835407221688629870L;

    /** 付款人 */
    @NotBlank(message = "付款人不能为空")
    private String            payer_member_id;

    /** 收款人 */
    @NotNull(message = "收款人不能为空")
    private String            payee_member_id;

    /** 分账来源：产品 */
    private String            split_source;

    /** 分账系数 */
    private Double            split_rate;

    /** 分润金额,单位：元 */
    @NotNull(message = "分润金额不能为空")
    private BigDecimal        amount;

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
     * Getter method for property <tt>split_source</tt>.
     * 
     * @return property value of split_source
     */
    public String getSplit_source() {
        return split_source;
    }

    /**
     * Setter method for property <tt>split_source</tt>.
     * 
     * @param split_source value to be assigned to property split_source
     */
    public void setSplit_source(String split_source) {
        this.split_source = split_source;
    }

    /**
     * Getter method for property <tt>split_rate</tt>.
     * 
     * @return property value of split_rate
     */
    public Double getSplit_rate() {
        return split_rate;
    }

    /**
     * Setter method for property <tt>split_rate</tt>.
     * 
     * @param split_rate value to be assigned to property split_rate
     */
    public void setSplit_rate(Double split_rate) {
        this.split_rate = split_rate;
    }

    /**
     * Getter method for property <tt>amount</tt>.
     * 
     * @return property value of amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Setter method for property <tt>amount</tt>.
     * 
     * @param amount value to be assigned to property amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
