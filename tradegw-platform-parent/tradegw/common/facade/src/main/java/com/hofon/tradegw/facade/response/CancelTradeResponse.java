/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 取消交易返回对象
 * @author xilu.tong
 * @version $Id: CancelTradeResponse.java, v0.1 2015年11月27日 下午2:32:02 xilu.tong Exp $
 */
public class CancelTradeResponse extends BasePublicResponse {

    /** SID */
    private static final long serialVersionUID = -1213339497245772476L;

    /** 交易流水号号 */
    private String            trade_no;

    /** 交易状态 */
    private String            trade_state;

    public CancelTradeResponse() {
        this.setIs_success('1');
    }

    public CancelTradeResponse(TradegwResultCode resultCode) {
        this.setIs_success('0');
        this.setError_code(resultCode.getCode());
        this.setError_msg(resultCode.getMsg());
    }

    public CancelTradeResponse(String code, String msg) {
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
     * Getter method for property <tt>trade_state</tt>.
     * 
     * @return property value of trade_state
     */
    public String getTrade_state() {
        return trade_state;
    }

    /**
     * Setter method for property <tt>trade_state</tt>.
     * 
     * @param trade_state value to be assigned to property trade_state
     */
    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

}
