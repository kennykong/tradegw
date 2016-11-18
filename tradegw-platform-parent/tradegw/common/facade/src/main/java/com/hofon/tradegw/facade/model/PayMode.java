/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import org.apache.commons.lang.StringUtils;

/**
 * 支付方式
 * 
 * @author xilu.tong
 * @version $Id: PayMode.java, v0.1 2015年10月4日 下午6:47:45 xilu.tong Exp $
 */
public enum PayMode {

    // 现金支付
    CASH("cash", "现金支付"),

    // 余额支付
    BALANCE("balance", "余额支付"),

    // 银联支付
    UNIONPAY("unionpay_web", "银联支付"),

    // 支付宝支付
    ALIPAY("alipay_web", "支付宝支付"),

    // 微信支付
    WEIXIN("weixin", "微信支付"),

    // 有价券抵扣
    EXCHANGE("exchange", "有价券抵扣"), ;

    private String code;

    private String msg;

    private PayMode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static PayMode getEnum(String code) {
        PayMode[] list = values();
        for (PayMode emun : list) {
            if (null == emun) {
                continue;
            }

            if (StringUtils.equals(code, emun.getCode())) {
                return emun;
            }
        }
        return null;
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
