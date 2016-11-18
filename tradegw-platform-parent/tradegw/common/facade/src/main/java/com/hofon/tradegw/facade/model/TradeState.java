/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;


/**
 * 交易状态
 * 
 * @author xilu.tong
 * @version $Id: TradeState.java, v0.1 2015年10月2日 下午8:07:19 xilu.tong Exp $
 */
public enum TradeState {

    UNPAY("unpay", "待支付"),

    CANCEL("cancel", "交易取消"),

    CLOSE("close", "交易关闭"),

    DELIVERY("delivery", "等待发货"),

    CONFIRM("confirm", "等待确认收货"),

    SUCCESS("success", "交易成功"),

    FINISH("finish", "交易完成"), ;

    private String code;

    private String msg;

    private TradeState(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>msg</tt>.
     * 
     * @return property value of msg
     */
    public String getMsg() {
        return msg;
    }

}
