/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 抵用券对象
 * @author xilu.tong
 * @version $Id: Exchange.java, v0.1 2015年11月27日 下午1:39:34 xilu.tong Exp $
 */
public class Exchange implements Serializable {

    /** SID */
    private static final long serialVersionUID = 2063962886347962652L;

    /** 抵用券类型,points:积分 | coin:金币 | voucher:优惠券 */
    @NotBlank(message = "抵用券类型不能为空")
    private String            couponType       = "points";

    /** 抵用券[数量|面额] */
    @NotNull(message = "抵用券数量不能为空")
    private Long              count;

    /** 抵用金额 */
    @NotNull(message = "抵用金额不能为空")
    private BigDecimal        amount;

    /**
     * Getter method for property <tt>couponType</tt>.
     * 
     * @return property value of couponType
     */
    public String getCouponType() {
        return couponType;
    }

    /**
     * Setter method for property <tt>couponType</tt>.
     * 
     * @param couponType value to be assigned to property couponType
     */
    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }

    /**
     * Getter method for property <tt>count</tt>.
     * 
     * @return property value of count
     */
    public Long getCount() {
        return count;
    }

    /**
     * Setter method for property <tt>count</tt>.
     * 
     * @param count value to be assigned to property count
     */
    public void setCount(Long count) {
        this.count = count;
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
