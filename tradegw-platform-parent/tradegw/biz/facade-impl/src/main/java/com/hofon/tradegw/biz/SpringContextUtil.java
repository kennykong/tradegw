/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2015 All Rights Reserved.
 */
package com.hofon.tradegw.biz;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;

import com.zhuking.common.lang.StringUtil;

/**
 * 服务接口拾取器
 * @author xilu.tong
 * @version $Id: SpringContextUtil.java, v0.1 2015年11月23日 下午3:15:59 xilu.tong Exp $
 */
public class SpringContextUtil implements ApplicationContextAware {

    private Logger                    logger   = LoggerFactory.getLogger(SpringContextUtil.class);

    private static ApplicationContext appCtx;

    private Map<String, Object>       routeMap = new ConcurrentHashMap<String, Object>();

    /**
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
        registerService();
    }

    /**
     * 注册服务接口
     */
    private void registerService() {
        Map<String, Object> allWebResBeans = appCtx.getBeansWithAnnotation(ServiceRoute.class);
        for (Object bean : allWebResBeans.values()) {
            String routeName = getServiceRoute(bean);
            if (routeName != null) {
                routeMap.put(routeName, bean);
                this.logger.debug("register route,routeName={},bean={}", new Object[] { routeName,
                        bean });
            }
        }
    }

    /**
     * 根据服务接口bean获取服务接口名称
     * 
     * @param bean
     * @return
     */
    private String getServiceRoute(Object bean) {
        if (bean != null) {
            Annotation anno = AnnotationUtils.getAnnotation(bean.getClass(), ServiceRoute.class);
            if (anno != null) {
                return (String) AnnotationUtils.getValue(anno, "name");
            }
        }
        return null;
    }

    /**
     * 根据服务名称获取服务实例对象
     * 
     * @param name
     * @return
     */
    public Object getServiceByAnnoName(String name) {
        if (StringUtil.isNotEmpty(name)) {
            return routeMap.get(name);
        }
        return null;
    }

}
