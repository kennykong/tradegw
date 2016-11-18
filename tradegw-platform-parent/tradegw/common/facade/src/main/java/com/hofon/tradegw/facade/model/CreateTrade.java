/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 交易创建基本对象
 * @author xilu.tong
 * @version $Id: CreateTrade.java, v0.1 2015年11月28日 下午2:56:50 xilu.tong Exp $
 */
public class CreateTrade implements Serializable {

    /** SID */
    private static final long serialVersionUID = 6013367901853232728L;

    /** 外部订单号 */
    @NotBlank(message = "外部订单号不能为空")
    private String            outer_biz_no;

    /** 收款方 */
    @NotBlank(message = "收款方不能为空")
    private String            payee_member_id;

    /** 产品订单URL */
    @NotBlank(message = "产品订单URL不能为空")
    private String            biz_order_url;

    /** 总金额 */
    @NotNull(message = "总金额不能为空")
    private BigDecimal        total_amount     = new BigDecimal(0);

    /** 交易类型： ensure-担保交易、direct-即时到账 */
    private String            trade_type       = "ensure";

    /** 产品集 */
    private List<Product>     products;

    /** 分润参与方参数集 */
    private List<Royalty>     royalties;

    /** 有价券抵用参数集 */
    private List<Exchange>    exchanges;

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
     * Getter method for property <tt>payee_member_id</tt>.
     * 
     * @return property value of payee_member_id
     */
    public String getPayee_member_id() {
        return payee_member_id;
    }

    /**
     * Setter method for property <tt>payee_member_id</tt>.
     * 
     * @param payee_member_id value to be assigned to property payee_member_id
     */
    public void setPayee_member_id(String payee_member_id) {
        this.payee_member_id = payee_member_id;
    }

    /**
     * Getter method for property <tt>biz_order_url</tt>.
     * 
     * @return property value of biz_order_url
     */
    public String getBiz_order_url() {
        return biz_order_url;
    }

    /**
     * Setter method for property <tt>biz_order_url</tt>.
     * 
     * @param biz_order_url value to be assigned to property biz_order_url
     */
    public void setBiz_order_url(String biz_order_url) {
        this.biz_order_url = biz_order_url;
    }

    /**
     * Getter method for property <tt>total_amount</tt>.
     * 
     * @return property value of total_amount
     */
    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    /**
     * Setter method for property <tt>total_amount</tt>.
     * 
     * @param total_amount value to be assigned to property total_amount
     */
    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    /**
     * Getter method for property <tt>trade_type</tt>.
     * 
     * @return property value of trade_type
     */
    public String getTrade_type() {
        return trade_type;
    }

    /**
     * Setter method for property <tt>trade_type</tt>.
     * 
     * @param trade_type value to be assigned to property trade_type
     */
    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    /**
     * Getter method for property <tt>products</tt>.
     * 
     * @return property value of products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Setter method for property <tt>products</tt>.
     * 
     * @param products value to be assigned to property products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * Getter method for property <tt>royalties</tt>.
     * 
     * @return property value of royalties
     */
    public List<Royalty> getRoyalties() {
        return royalties;
    }

    /**
     * Setter method for property <tt>royalties</tt>.
     * 
     * @param royalties value to be assigned to property royalties
     */
    public void setRoyalties(List<Royalty> royalties) {
        this.royalties = royalties;
    }

    /**
     * Getter method for property <tt>exchanges</tt>.
     * 
     * @return property value of exchanges
     */
    public List<Exchange> getExchanges() {
        return exchanges;
    }

    /**
     * Setter method for property <tt>exchanges</tt>.
     * 
     * @param exchanges value to be assigned to property exchanges
     */
    public void setExchanges(List<Exchange> exchanges) {
        this.exchanges = exchanges;
    }

}
