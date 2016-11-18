/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 增加积分
 * @author hofon
 * @version $Id: AddPointsRequest.java, v0.1 2015年12月19日 上午10:49:37 hofon Exp $
 */
public class AddPointsRequest extends BasePublicRequest {

    /** SID */
    private static final long serialVersionUID = -8549956012534265280L;

    /** 积分数量 */
    @NotNull(message = "count不能为空")
    private Long              count;

    @NotBlank(message = "memberId不能为空")
    private String            memberId;

    /**
     * Getter method for property <tt>count</tt>.
     * 
     * @return property value of count
     */
    public Long getCount() {
        return count;
    }

    /**
     * Setter method for property <tt>count</tt>.
     * 
     * @param count value to be assigned to property count
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * Getter method for property <tt>memberId</tt>.
     * 
     * @return property value of memberId
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * Setter method for property <tt>memberId</tt>.
     * 
     * @param memberId value to be assigned to property memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

}
