/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

/**
 * 签名类型
 * @author xilu.tong
 * @version $Id: SignType.java, v0.1 2015年11月27日 下午5:16:11 xilu.tong Exp $
 */
public enum SignType {

    RSA("RSA"),

    DSA("DSA"),

    MD5("MD5"), ;

    private String code;

    private SignType(String code) {
        this.code = code;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

}
