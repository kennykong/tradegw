/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import java.util.ArrayList;
import java.util.List;

import com.hofon.tradegw.facade.model.TradeRes;
import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 创建交易返回对象
 * @author xilu.tong
 * @version $Id: CreateTradeResponse.java, v0.1 2015年11月27日 下午2:33:04 xilu.tong Exp $
 */
public class CreateTradeResponse extends BasePublicResponse {

    /** SID */
    private static final long serialVersionUID = 5672292384286897339L;

    /** 返回交易订单列表 */
    private List<TradeRes>    trades           = new ArrayList<TradeRes>();

    public CreateTradeResponse() {
        this.setIs_success('1');
    }

    public CreateTradeResponse(TradegwResultCode resultCode) {
        this.setIs_success('0');
        this.setError_code(resultCode.getCode());
        this.setError_msg(resultCode.getMsg());
    }

    public CreateTradeResponse(String code, String msg) {
        this.setIs_success('0');
        this.setError_code(code);
        this.setError_msg(msg);
    }

    /**
     * Getter method for property <tt>trades</tt>.
     * 
     * @return property value of trades
     */
    public List<TradeRes> getTrades() {
        return trades;
    }

    /**
     * Setter method for property <tt>trades</tt>.
     * 
     * @param trades value to be assigned to property trades
     */
    public void setTrades(List<TradeRes> trades) {
        this.trades = trades;
    }

}
