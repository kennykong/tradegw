/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import java.util.List;

import com.hofon.tradegw.facade.model.TradeOrder;
import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 交易查询返回对象
 * @author xilu.tong
 * @version $Id: QueryTradeResponse.java, v0.1 2015年11月27日 下午2:33:54 xilu.tong Exp $
 */
public class QueryTradeResponse extends BasePublicResponse {

    /** SID */
    private static final long serialVersionUID = 8285839166853752817L;

    private List<TradeOrder>  tradeList;

    public QueryTradeResponse() {
        this.setIs_success('1');
    }

    public QueryTradeResponse(TradegwResultCode resultCode) {
        this.setIs_success('0');
        this.setError_code(resultCode.getCode());
        this.setError_msg(resultCode.getMsg());
    }

    public QueryTradeResponse(String code, String msg) {
        this.setIs_success('0');
        this.setError_code(code);
        this.setError_msg(msg);
    }

    /**
     * Getter method for property <tt>tradeList</tt>.
     * 
     * @return property value of tradeList
     */
    public List<TradeOrder> getTradeList() {
        return tradeList;
    }

    /**
     * Setter method for property <tt>tradeList</tt>.
     * 
     * @param tradeList value to be assigned to property tradeList
     */
    public void setTradeList(List<TradeOrder> tradeList) {
        this.tradeList = tradeList;
    }

}
