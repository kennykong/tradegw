/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.response;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hofon.tradegw.facade.model.TradegwResultCode;

/**
 * 公共返回参数
 * @author xilu.tong
 * @version $Id: BasePublicResponse.java, v0.1 2015年11月27日 上午11:34:59 xilu.tong Exp $
 */
public class BasePublicResponse implements Serializable {

    /** SID */
    private static final long serialVersionUID = -6824149018614384629L;

    /** 是否成功，1 - 成功 ；0 - 失败 */
    private char              is_success;

    /** 访问令牌 */
    private String            token;

    /** 参数编码字符集，默认UTF-8 */
    private String            input_charset    = "UTF-8";

    /** 错误码 */
    private String            error_code;

    /** 错误描述 */
    private String            error_msg;

    /** 备注 */
    private String            memo;

    public BasePublicResponse() {
        this.setIs_success('1');
    }

    public BasePublicResponse(TradegwResultCode resultCode) {
        this.is_success = 0;
        this.error_code = resultCode.getCode();
        this.error_msg = resultCode.getMsg();
    }

    /**
     * Getter method for property <tt>is_success</tt>.
     * 
     * @return property value of is_success
     */
    public char getIs_success() {
        return is_success;
    }

    /**
     * Setter method for property <tt>is_success</tt>.
     * 
     * @param is_success value to be assigned to property is_success
     */
    public void setIs_success(char is_success) {
        this.is_success = is_success;
    }

    /**
     * Getter method for property <tt>token</tt>.
     * 
     * @return property value of token
     */
    public String getToken() {
        return token;
    }

    /**
     * Setter method for property <tt>token</tt>.
     * 
     * @param token value to be assigned to property token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Getter method for property <tt>input_charset</tt>.
     * 
     * @return property value of input_charset
     */
    public String getInput_charset() {
        return input_charset;
    }

    /**
     * Setter method for property <tt>input_charset</tt>.
     * 
     * @param input_charset value to be assigned to property input_charset
     */
    public void setInput_charset(String input_charset) {
        this.input_charset = input_charset;
    }

    /**
     * Getter method for property <tt>error_code</tt>.
     * 
     * @return property value of error_code
     */
    public String getError_code() {
        return error_code;
    }

    /**
     * Setter method for property <tt>error_code</tt>.
     * 
     * @param error_code value to be assigned to property error_code
     */
    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    /**
     * Getter method for property <tt>error_msg</tt>.
     * 
     * @return property value of error_msg
     */
    public String getError_msg() {
        return error_msg;
    }

    /**
     * Setter method for property <tt>error_msg</tt>.
     * 
     * @param error_msg value to be assigned to property error_msg
     */
    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    /**
     * Getter method for property <tt>memo</tt>.
     * 
     * @return property value of memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * Setter method for property <tt>memo</tt>.
     * 
     * @param memo value to be assigned to property memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
