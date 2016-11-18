/**
 * Hofon.com Inc.
 * Copyright (c) 2010-2016 All Rights Reserved.
 */
package com.hofon.tradegw.test;

import com.zhuking.common.util.HttpClientUtil;

/**
 * 
 * @author hofon
 * @version $Id: TradegwTest.java, v0.1 2016年4月21日 下午3:01:11 hofon Exp $
 */
public class TradegwTest {

    private static final String key = "jsonReq";

    private static final String url = "http://114.55.0.41:8102/tradegw/tradegw.json";

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        String resposne = HttpClientUtil.sendPost(url, key, "{}");
        System.out.println(resposne);
    }

}
