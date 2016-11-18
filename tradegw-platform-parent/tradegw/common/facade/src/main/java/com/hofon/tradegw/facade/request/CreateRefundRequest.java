/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 创建退款请求
 * <pre>目前仅支持全额退款</pre>
 * @author xilu.tong
 * @version $Id: CreateRefundRequest.java, v0.1 2015年11月27日 上午11:45:25 xilu.tong Exp $
 */
public class CreateRefundRequest extends BasePublicRequest {

    /** SID */
    private static final long serialVersionUID = -3717586668383256440L;

    /** 交易流水号 */
    @NotBlank(message = "交易流水号不能为空")
    private String            trade_no;

    /** 退款金额 */
    @NotNull(message = "refund_amount不能为空")
    private BigDecimal        refund_amount;

    /** 退款原因 */
    private String            refund_reason;

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
     * Getter method for property <tt>refund_amount</tt>.
     * 
     * @return property value of refund_amount
     */
    public BigDecimal getRefund_amount() {
        return refund_amount;
    }

    /**
     * Setter method for property <tt>refund_amount</tt>.
     * 
     * @param refund_amount value to be assigned to property refund_amount
     */
    public void setRefund_amount(BigDecimal refund_amount) {
        this.refund_amount = refund_amount;
    }

    /**
     * Getter method for property <tt>refund_reason</tt>.
     * 
     * @return property value of refund_reason
     */
    public String getRefund_reason() {
        return refund_reason;
    }

    /**
     * Setter method for property <tt>refund_reason</tt>.
     * 
     * @param refund_reason value to be assigned to property refund_reason
     */
    public void setRefund_reason(String refund_reason) {
        this.refund_reason = refund_reason;
    }

}
