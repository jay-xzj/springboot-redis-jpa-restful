/*
 * Copyright (c) 2012-2014 by Asiainfo Linkage
 * All rights reserved.
 * $Id: EsbXmlHelper.java 112 2015-02-10 11:13:29Z wanglf $
 */
package com.crm.esb.invoke;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.asiainfo.tools.xml.XMLMakeup;
import com.asiainfo.tools.xml.XMLUtil;
import com.crm.esb.invoke.pojo.RespParam;

import net.sf.json.JSONObject;





/**
 * ESB返回报文解析类
 * @User: mayc
 * @Date: 2014年4月24日
 * @Time: 下午2:00:09
 * @version $Revision: 112 $ $Date: 2015-02-10 19:13:29 +0800 (周二, 10 二月 2015) $
 */
public class EsbXmlHelper implements IEsbXmlHelper<RespParam> {
    private final static Log                 log = LogFactory.getLog(EsbXmlHelper.class);

    public RespParam parseXml(String xml,Class<RespParam> clazz) throws Exception {
        long      start = System.currentTimeMillis();

        RespParam respParam = new RespParam();
        try {
            //edit by wangfeng2
            XMLMakeup x= XMLUtil.getDataFromString(xml);
            parsePubInfo(respParam,x);
            parseBusiInfo(respParam,x);

        } catch (Exception e) {
            log.error(e);
            throw new Exception("Parse Xml error", e);
        }
        long end = System.currentTimeMillis();
        if (log.isDebugEnabled()) {
            log.debug("解析的 xml：\t" + xml);
            log.debug("解析 xml共花费了：" + (end - start) + " ms");
            log.debug("json={}," + JSONObject.fromObject(respParam));
        }
        return respParam;
    }

	protected void parsePubInfo(RespParam respParam,XMLMakeup xml) {
        List<XMLMakeup> xs = xml.getChild("PUB_INFO")[0].getChildren();
        Map<String,String> pubinfo = new HashMap<String,String>();
        for(XMLMakeup x :xs)
            pubinfo.put(x.getName(),x.getText());
        respParam.setPubInfo(pubinfo);
    }
    protected void parseBusiInfo(RespParam respParam,XMLMakeup xml) {
        Map<String, Object> busiInfo = new HashMap<String, Object>();
        getElementIterator(busiInfo, xml.getChild("BUSI_INFO")[0]);
        respParam.setBusiInfo(busiInfo);
    }
    protected void getElementIterator(Map<String, Object> rootMap, XMLMakeup element) {
        Map<String, Object> elemMap = new HashMap<String, Object>();
        List<XMLMakeup> iter = element.getChildren();
        for (XMLMakeup x:iter) {
            String  nodeName = x.getName();
            //System.out.println(childEle.elements().size());
            if (x.getChildren().size() == 0) {
                String nodeValue = x.getText();
                elemMap.put(nodeName, nodeValue);
            } else {
                getElementIterator(elemMap, x);
            }
        }
        if (!elemMap.isEmpty()) {
            String rootEleName = element.getName();
            if (rootMap.containsKey(rootEleName)) {
                Object obj = rootMap.get(rootEleName);
                if (obj instanceof List) {
                    List listData = (List) obj;
                    listData.add(elemMap);
                    rootMap.put(rootEleName, listData);
                } else if (obj instanceof Map) {
                    List nList = new ArrayList();
                    nList.add(obj);
                    nList.add(elemMap);
                    rootMap.put(rootEleName, nList);
                }
            } else {
                rootMap.put(rootEleName, elemMap);
            }
        }
    }
    
	public RespParam parseXml(String xml, Class<RespParam> clz,
			String pubChildName, String busiChildName) throws Exception {
		long start = System.currentTimeMillis();
		RespParam respParam = new RespParam();
		try {
			XMLMakeup x = XMLUtil.getDataFromString(xml);
			parsePubInfo(respParam, x, pubChildName);
			parseBusiInfo(respParam, x, busiChildName);
		} catch (Exception e) {
			log.error(e);
			throw new Exception("Parse Xml error", e);
		}
		long end = System.currentTimeMillis();
		if (log.isDebugEnabled()) {
			log.debug("解析的 xml：\t" + xml);
			log.debug("解析 xml共花费了：" + (end - start) + " ms");
			log.debug("json={}," + JSONObject.fromObject(respParam));
		}

		return respParam;
	}
	
    /**
     * ESB接口返回报文时，children名称不是PUB_INFO 和 BUSI_INFO
     */
    protected void parsePubInfo(RespParam respParam, XMLMakeup xml,
			String childName) {
		List<XMLMakeup> xs = xml.getChild(childName)[0].getChildren();
		Map pubinfo = new HashMap();
		for (XMLMakeup x : xs)
			pubinfo.put(x.getName(), x.getText());
		respParam.setPubInfo(pubinfo);
	}
    
	/**
     * ESB接口返回报文时，children名称不是PUB_INFO 和 BUSI_INFO
     */
    protected void parseBusiInfo(RespParam respParam, XMLMakeup xml,
			String childName) {
		Map<String, Object> busiInfo = new HashMap<String, Object>();
		getElementIterator(busiInfo, xml.getChild(childName)[0]);
		respParam.setBusiInfo(busiInfo);
	}
    
    public static void main(String[] args) throws IOException {
    	EsbXmlHelper helper = new EsbXmlHelper();
		String xml ="<?xml version='1.0' encoding='UTF-8' ?><root><关键信息区><一级项><项目ID></项目ID><项目名>扣除本期费用后充值账户余额</项目名><金额>419.60</金额></一级项><一级项><项目ID></项目ID><项目名>本月费用总额</项目名><金额>64.93</金额><二级项集合><二级项><项目ID></项目ID><项目名>个人实际消费</项目名><金额>64.93</金额></二级项></二级项集合></一级项><一级项><项目ID></项目ID><项目名>欠费（不包括本月费用）</项目名><金额>0.00</金额></一级项></root>";
		 XMLMakeup xmlmakeup= XMLUtil.getDataFromString(xml);
		 Map<String, Object> busiInfo = new HashMap<String, Object>();
		 helper.getElementIterator(busiInfo, xmlmakeup.getChild("关键信息区")[0]);
		 System.out.println(JSONObject.fromObject(busiInfo));
	}
}
