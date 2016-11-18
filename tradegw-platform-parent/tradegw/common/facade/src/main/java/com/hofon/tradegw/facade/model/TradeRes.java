/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易返回
 * @author xilu.tong
 * @version $Id: TradeRes.java, v0.1 2015年11月28日 下午9:52:26 xilu.tong Exp $
 */
public class TradeRes implements Serializable {

    /** SID */
    private static final long serialVersionUID = -4140847996551983323L;

    /** 外部订单号 */
    private String            outer_biz_no;

    /** 交易流水号 */
    private String            trade_no;

    /** 总金额 */
    private BigDecimal        total_amount;

    /** 交易状态 */
    private String            tradeState;

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
     * Getter method for property <tt>tradeState</tt>.
     * 
     * @return property value of tradeState
     */
    public String getTradeState() {
        return tradeState;
    }

    /**
     * Setter method for property <tt>tradeState</tt>.
     * 
     * @param tradeState value to be assigned to property tradeState
     */
    public void setTradeState(String tradeState) {
        this.tradeState = tradeState;
    }

}
