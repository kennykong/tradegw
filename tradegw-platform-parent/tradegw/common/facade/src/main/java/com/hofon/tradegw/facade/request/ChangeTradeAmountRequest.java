/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 修改交易金额请求
 * @author xilu.tong
 * @version $Id: ChangeTradeAmountRequest.java, v0.1 2015年11月27日 下午1:04:10 xilu.tong Exp $
 */
public class ChangeTradeAmountRequest extends BasePublicRequest {

    /** SID */
    private static final long serialVersionUID = -3202005981758849718L;

    /** 交易流水号号 */
    @NotBlank(message = "trade_no不能为空")
    private String            trade_no;

    /** 交易金额 */
    @NotNull(message = "trade_amount不能为空")
    private BigDecimal        trade_amount;

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

}
