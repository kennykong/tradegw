/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import org.apache.commons.lang.StringUtils;

/**
 * 交易网关处理结果枚举
 * @author xilu.tong
 * @version $Id: TradegwResultCode.java, v0.1 2015年11月27日 下午6:08:31 xilu.tong Exp $
 */
public enum TradegwResultCode {

    SUCCESS("T", "成功"),

    FAILED("F", "失败"),

    NOT_AUTH("NOT_AUTH", "未授权"),

    INVALID_OPERATE("INVALID_OPERATE", "非法操作"),

    VERIFY_SIGN_FAIL("VERIFY_SIGN_FAIL", "验签失败"),

    PARAM_INVALID("PARAM_INVALID", "参数不合法，请检查"),

    PARAM_EMPTY("PARAM_EMPTY", "参数为空，请检查"),

    MEMBER_NOT_LOGIN("MEMBER_NOT_LOGIN", "会员未登录"),

    MEMBER_NOT_ENABLE("MEMBER_NOT_ENABLE", "会员账户无效"),

    MEMBER_NOT_EXIST("MEMBER_NOT_EXIST", "会员不存在"),

    TRADE_NOT_EXIST("TRADE_NOT_EXIST", "交易不存在"),

    AMOUNT_NOT_INVALID("AMOUNT_NOT_INVALID", "交易金额不合法，请参阅入参说明"),

    BALANCE_NOT_ENOUGH("BALANCE_NOT_ENOUGH", "账户余额不足"),

    POINTS_NOT_ENOUGH("POINTS_NOT_ENOUGH", "积分余额不足"),

    VOUCHER_NOT_EXIST("VOUCHER_NOT_EXIST", "凭证不存在"),

    VOUCHER_EXIST("VOUCHER_EXIST", "凭证已存在，请勿重复下单"),

    SYSTEM_ERROR("SYSTEM_ERROR", "系统异常，请稍后重试"), ;

    private String code;

    private String msg;

    private TradegwResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static TradegwResultCode getEnum(String code) {
        TradegwResultCode[] list = values();
        for (TradegwResultCode emun : list) {
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
