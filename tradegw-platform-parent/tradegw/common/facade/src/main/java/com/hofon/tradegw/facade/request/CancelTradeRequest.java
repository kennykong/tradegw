/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 取消交易请求
 * @author xilu.tong
 * @version $Id: CancelTradeRequest.java, v0.1 2015年11月27日 下午1:04:10 xilu.tong Exp $
 */
public class CancelTradeRequest extends BasePublicRequest {

    /** SID */
    private static final long serialVersionUID = -3202005981758849718L;

    /** 交易流水号 */
    @NotBlank(message = "交易流水号不能为空")
    private String            trade_no;

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

}
