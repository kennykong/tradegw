/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.hofon.tradegw.facade.model.CreateTrade;

/**
 * 交易创建请求
 * @author xilu.tong
 * @version $Id: CreateTradeRequest.java, v0.1 2015年11月27日 上午11:45:25 xilu.tong Exp $
 */
public class CreateTradeRequest extends BasePublicRequest {

    /** SID */
    private static final long serialVersionUID = -3717586668383256440L;

    /** 商户ID */
    private String            merchant_id;

    /** 付款方 */
    @NotBlank(message = "付款方不能为空")
    private String            payer_member_id;

    /** 支付订单 */
    @NotEmpty(message = "支付订单不能为空")
    private List<CreateTrade> orders           = new ArrayList<CreateTrade>();

    /**
     * Getter method for property <tt>payer_member_id</tt>.
     * 
     * @return property value of payer_member_id
     */
    public String getPayer_member_id() {
        return payer_member_id;
    }

    /**
     * Setter method for property <tt>payer_member_id</tt>.
     * 
     * @param payer_member_id value to be assigned to property payer_member_id
     */
    public void setPayer_member_id(String payer_member_id) {
        this.payer_member_id = payer_member_id;
    }

    /**
     * Getter method for property <tt>orders</tt>.
     * 
     * @return property value of orders
     */
    public List<CreateTrade> getOrders() {
        return orders;
    }

    /**
     * Setter method for property <tt>orders</tt>.
     * 
     * @param orders value to be assigned to property orders
     */
    public void setOrders(List<CreateTrade> orders) {
        this.orders = orders;
    }

    /**
     * Getter method for property <tt>merchant_id</tt>.
     * 
     * @return property value of merchant_id
     */
    public String getMerchant_id() {
        return merchant_id;
    }

    /**
     * Setter method for property <tt>merchant_id</tt>.
     * 
     * @param merchant_id value to be assigned to property merchant_id
     */
    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

}
