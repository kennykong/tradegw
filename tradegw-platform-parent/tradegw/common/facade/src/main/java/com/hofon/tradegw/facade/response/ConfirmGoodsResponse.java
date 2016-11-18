/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 确认收货返回对象
 * @author xilu.tong
 * @version $Id: ConfirmGoodsResponse.java, v0.1 2015年11月27日 下午2:32:41 xilu.tong Exp $
 */
public class ConfirmGoodsResponse extends BasePublicResponse {

    /** SID */
    private static final long serialVersionUID = -5875859464101828802L;

    /** 外部订单号 */
    private String            outer_biz_no;

    /** 交易流水号 */
    private String            trade_no;

    /** 交易状态 */
    private String            tradeState;

    public ConfirmGoodsResponse() {
        this.setIs_success('1');
    }

    public ConfirmGoodsResponse(TradegwResultCode resultCode) {
        this.setIs_success('0');
        this.setError_code(resultCode.getCode());
        this.setError_msg(resultCode.getMsg());
    }

    public ConfirmGoodsResponse(String code, String msg) {
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
