/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 服务路由
 * @author xilu.tong
 * @version $Id: ServiceRoute.java, v0.1 2015年11月23日 下午3:15:59 xilu.tong Exp $
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ServiceRoute {
    public String name();
}
