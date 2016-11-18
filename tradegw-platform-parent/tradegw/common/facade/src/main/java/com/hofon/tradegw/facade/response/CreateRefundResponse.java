/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import java.math.BigDecimal;

import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 退款交易创建
 * @author xilu.tong
 * @version $Id: CreateRefundResponse.java, v0.1 2015年11月27日 下午2:33:24 xilu.tong Exp $
 */
public class CreateRefundResponse extends BasePublicResponse {

    /** SID */
    private static final long serialVersionUID = 2875550095706580576L;

    /** 外部订单号 */
    private String            outer_biz_no;

    /** 交易流水号 */
    private String            trade_no;

    /** 退款金额 */
    private BigDecimal        refund_amount;

    /** 退款状态 */
    private String            refundState;

    public CreateRefundResponse() {
        this.setIs_success('1');
    }

    public CreateRefundResponse(TradegwResultCode resultCode) {
        this.setIs_success('0');
        this.setError_code(resultCode.getCode());
        this.setError_msg(resultCode.getMsg());
    }

    public CreateRefundResponse(String code, String msg) {
        this.setIs_success('0');
        this.setError_code(code);
        this.setError_msg(msg);
    }

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
     * Getter method for property <tt>refundState</tt>.
     * 
     * @return property value of refundState
     */
    public String getRefundState() {
        return refundState;
    }

    /**
     * Setter method for property <tt>refundState</tt>.
     * 
     * @param refundState value to be assigned to property refundState
     */
    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }

}
