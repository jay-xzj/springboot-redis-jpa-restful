/*
 * Copyright (c) 2012-2014 by Asiainfo Linkage
 * All rights reserved.
 * $Id: CollectionsUtil.java 65 2015-02-10 11:13:29Z wanglf $
 */
package com.crm.comm.cfgdata.base.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.asiainfo.utils.ObjectUtil;
import com.asiainfo.utils.StringUtil;


/**
 * 集合处理类
 * @User: mayc
 * @Date: 2014年4月25日
 * @Time: 上午10:35:49
 * @version $Revision: 65 $ $Date: 2015-02-10 19:13:29 +0800 (周二, 10 二月 2015) $
 */
public class CollectionsUtil {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static List getListBusiInfo(Map<String, Object> busiInfo, String key) {
        List list = new ArrayList();
        if (busiInfo != null) {
            Object obj = busiInfo.get(key);
            if (obj != null) {
                if (obj instanceof List) {
                    return (List) obj;
                }

                if (obj instanceof Map) {
                    list.add(obj);
                }
            }
        }

        return list;
    }

    @SuppressWarnings("rawtypes")
    public static List getListBusiInfo(Map<String, Object> busiInfo, String... keys) {
        List list = new ArrayList();
        if (!ObjectUtil.isBlank(keys)) {
            if (keys.length == 1) {
                list = getListBusiInfo(busiInfo, keys[0]);
            } else {
                Map<String, Object> respMap = busiInfo;
                for (int i = 0; i < (keys.length - 1); i++) {
                    respMap = getMapBusiInfo(respMap, keys[i]);
                    if (ObjectUtil.isBlank(respMap)) {
                        break;
                    }
                }

                list = getListBusiInfo(respMap, keys[keys.length - 1]);
            }
        }

        return list;
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> getMapBusiInfo(Map<String, Object> busiInfo, String... keys) {
        if (ObjectUtil.isBlank(keys)) {
            return Collections.EMPTY_MAP;
        }

        Map<String, Object> respMap = busiInfo;
        for (int i = 0; i < keys.length; i++) {
            respMap = getMapBusiInfo(respMap, keys[i]);
            if (ObjectUtil.isBlank(respMap)) {
                break;
            }
        }

        return respMap;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map<String, Object> getMapBusiInfo(Map<String, Object> busiInfo, String key) {
        Map<String, Object> resMap = new HashMap<String, Object>();
        if (busiInfo != null) {
            Object item = busiInfo.get(key);
            if (item != null) {
                if (item instanceof List) {
                    resMap = (Map<String, Object>) ((List) item).get(0);
                } else if (item instanceof Map) {
                    resMap = (Map<String, Object>) item;
                }
            }
        }

        return resMap;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static Map<String, String> getMapStringBusInfo(Map<String, Object> busiInfo, String key) {
        Map<String, String> resMap = new HashMap<String, String>();
        if (busiInfo != null) {
            Object item = busiInfo.get(key);
            if (item != null) {
                if (item instanceof List) {
                    resMap = (Map<String, String>) ((List) item).get(0);
                } else if (item instanceof Map) {
                    resMap = (Map<String, String>) item;
                }
            }
        }

        return resMap;
    }

    public static Map<String, String> coverQueryString2Map(String queryStr) {
        Map<String, String> qryMap = new HashMap<String, String>();
        if (StringUtil.isNotEmpty(queryStr)) {
            String[] ps = queryStr.split("\\&");
            for (String p : ps) {
                if ((null != p) && !"".equals(p)) {
                    String[] kv = p.split("=");
                    if (kv.length == 2) {
                        if ((null != kv[0]) && (null != kv[1])) {
                            qryMap.put(StringUtil.trimToEmpty(kv[0]), StringUtil.trimToEmpty(kv[1]));
                        }
                    }
                }
            }
        }
        return qryMap;
    }
    
    public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		@SuppressWarnings("unchecked")
		T bean = (T) JSONObject.toBean(jsonObject, beanCalss);
		return bean;
	}
    
    public static Map<String, Object> json2MapObject(String json) {
		Map<String,Object> result = JSONObject.fromObject(json);
			return result == null? new HashMap<String,Object>():result;
	}
    
    public static long[] split(long[] source, int start, int end) {
        if (end > source.length) {
            return source;
        }
        long[] a = new long[end - start];
        for (int i = start; i < end; i++) {
            a[i - start] = source[i];
        }
        return a;
    }
}
