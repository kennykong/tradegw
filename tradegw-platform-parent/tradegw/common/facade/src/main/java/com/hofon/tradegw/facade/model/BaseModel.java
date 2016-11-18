/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.hofon.tradegw.facade.model;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 模型对象基类
 * @author hofon
 * @version $Id: BaseModel.java, v0.1 2016年3月14日 上午9:40:21 hofon Exp $
 */
public class BaseModel implements Serializable {

    /** SID */
    private static final long serialVersionUID = 5989217443740774012L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
