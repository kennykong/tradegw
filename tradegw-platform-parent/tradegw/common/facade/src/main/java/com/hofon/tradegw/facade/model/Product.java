/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 产品对象
 * @author hofon
 * @version $Id: Product.java, v0.1 2016年3月30日 下午5:33:42 hofon Exp $
 */
public class Product implements Serializable {

    /** SID */
    private static final long serialVersionUID = 1094661185012713326L;

    /** 商品码 */
    private String            prodCode;

    /** 商品名称 */
    private String            prodName;

    /** 商品图片 */
    private String            prodIcon;

    /** 商品详情URL */
    private String            prodDesc;

    /** 商品价格 */
    private BigDecimal        prodPrice;

    /** 商品数量 */
    private Integer           prodQuantity;

    /** 商品备注 */
    private String            memo;

    /**
     * Getter method for property <tt>prodCode</tt>.
     * 
     * @return property value of prodCode
     */
    public String getProdCode() {
        return prodCode;
    }

    /**
     * Setter method for property <tt>prodCode</tt>.
     * 
     * @param prodCode value to be assigned to property prodCode
     */
    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    /**
     * Getter method for property <tt>prodName</tt>.
     * 
     * @return property value of prodName
     */
    public String getProdName() {
        return prodName;
    }

    /**
     * Setter method for property <tt>prodName</tt>.
     * 
     * @param prodName value to be assigned to property prodName
     */
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    /**
     * Getter method for property <tt>prodIcon</tt>.
     * 
     * @return property value of prodIcon
     */
    public String getProdIcon() {
        return prodIcon;
    }

    /**
     * Setter method for property <tt>prodIcon</tt>.
     * 
     * @param prodIcon value to be assigned to property prodIcon
     */
    public void setProdIcon(String prodIcon) {
        this.prodIcon = prodIcon;
    }

    /**
     * Getter method for property <tt>prodDesc</tt>.
     * 
     * @return property value of prodDesc
     */
    public String getProdDesc() {
        return prodDesc;
    }

    /**
     * Setter method for property <tt>prodDesc</tt>.
     * 
     * @param prodDesc value to be assigned to property prodDesc
     */
    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    /**
     * Getter method for property <tt>prodPrice</tt>.
     * 
     * @return property value of prodPrice
     */
    public BigDecimal getProdPrice() {
        return prodPrice;
    }

    /**
     * Setter method for property <tt>prodPrice</tt>.
     * 
     * @param prodPrice value to be assigned to property prodPrice
     */
    public void setProdPrice(BigDecimal prodPrice) {
        this.prodPrice = prodPrice;
    }

    /**
     * Getter method for property <tt>prodQuantity</tt>.
     * 
     * @return property value of prodQuantity
     */
    public Integer getProdQuantity() {
        return prodQuantity;
    }

    /**
     * Setter method for property <tt>prodQuantity</tt>.
     * 
     * @param prodQuantity value to be assigned to property prodQuantity
     */
    public void setProdQuantity(Integer prodQuantity) {
        this.prodQuantity = prodQuantity;
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
