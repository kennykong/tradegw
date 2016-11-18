/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import java.math.BigDecimal;

import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 修改交易金额返回对象
 * @author xilu.tong
 * @version $Id: ChangeTradeAmountResponse.java, v0.1 2015年11月27日 下午2:32:16 xilu.tong Exp $
 */
public class ChangeTradeAmountResponse extends BasePublicResponse {

    /** SID */
    private static final long serialVersionUID = 8004646179440606849L;

    /** 交易流水号号 */
    private String            trade_no;

    /** 交易金额 */
    private BigDecimal        trade_amount;

    public ChangeTradeAmountResponse() {
        this.setIs_success('1');
    }

    public ChangeTradeAmountResponse(TradegwResultCode resultCode) {
        this.setIs_success('0');
        this.setError_code(resultCode.getCode());
        this.setError_msg(resultCode.getMsg());
    }

    public ChangeTradeAmountResponse(String code, String msg) {
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
