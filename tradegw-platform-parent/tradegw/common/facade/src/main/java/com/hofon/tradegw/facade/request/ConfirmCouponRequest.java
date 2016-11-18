/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 确认红包请求
 * @author xilu.tong
 * @version $Id: ConfirmCouponRequest.java, v0.1 2015年11月27日 上午11:45:25 xilu.tong Exp $
 */
public class ConfirmCouponRequest extends BasePublicRequest {

    /** SID */
    private static final long serialVersionUID = -3717586668383256440L;

    /** 交易流水号 */
    @NotBlank(message = "交易流水号不能为空")
    private String            trade_no;

    /** 红包接收人 */
    @NotBlank(message = "红包接收人不能为空")
    private String            receiver_member_id;

    /** 操作类型,1 - 接收 ；0 - 拒绝 */
    @NotBlank(message = "操作类型不能为空")
    private String            operate_type;

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

    /**
     * Getter method for property <tt>receiver_member_id</tt>.
     * 
     * @return property value of receiver_member_id
     */
    public String getReceiver_member_id() {
        return receiver_member_id;
    }

    /**
     * Setter method for property <tt>receiver_member_id</tt>.
     * 
     * @param receiver_member_id value to be assigned to property receiver_member_id
     */
    public void setReceiver_member_id(String receiver_member_id) {
        this.receiver_member_id = receiver_member_id;
    }

    /**
     * Getter method for property <tt>operate_type</tt>.
     * 
     * @return property value of operate_type
     */
    public String getOperate_type() {
        return operate_type;
    }

    /**
     * Setter method for property <tt>operate_type</tt>.
     * 
     * @param operate_type value to be assigned to property operate_type
     */
    public void setOperate_type(String operate_type) {
        this.operate_type = operate_type;
    }

}
