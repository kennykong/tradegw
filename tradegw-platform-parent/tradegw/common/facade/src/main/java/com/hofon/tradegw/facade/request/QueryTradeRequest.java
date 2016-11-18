/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.facade.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.hofon.tradegw.facade.model.BaseModel;

/**
 * 交易查询请求
 * @author xilu.tong
 * @version $Id: QueryTradeRequest.java, v0.1 2015年11月27日 上午11:45:25 xilu.tong Exp $
 */
public class QueryTradeRequest extends BaseModel {

    /** SID */
    private static final long serialVersionUID = -3717586668383256440L;

    /** 交易流水号 */
    private List<String>      trade_no;

    /** 查询开始时间 */
    @NotNull(message = "查询开始时间不能为空")
    private Date              startTime;

    /** 查询结束时间 */
    @NotNull(message = "查询结束时间不能为空")
    private Date              endTime;

    /**
     * Getter method for property <tt>trade_no</tt>.
     * 
     * @return property value of trade_no
     */
    public List<String> getTrade_no() {
        return trade_no;
    }

    /**
     * Setter method for property <tt>trade_no</tt>.
     * 
     * @param trade_no value to be assigned to property trade_no
     */
    public void setTrade_no(List<String> trade_no) {
        this.trade_no = trade_no;
    }

    /**
     * Getter method for property <tt>startTime</tt>.
     * 
     * @return property value of startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Setter method for property <tt>startTime</tt>.
     * 
     * @param startTime value to be assigned to property startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Getter method for property <tt>endTime</tt>.
     * 
     * @return property value of endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Setter method for property <tt>endTime</tt>.
     * 
     * @param endTime value to be assigned to property endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
