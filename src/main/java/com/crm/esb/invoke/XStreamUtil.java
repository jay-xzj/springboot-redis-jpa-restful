package com.crm.esb.invoke;

import com.crm.esb.invoke.pojo.PUB_INFO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


/**
 * 
* Copyright: Copyright (c) 2013 Asiainfo-Linkage
* 
* @ClassName: XStreamUtil.java
* @Description: 用于WS接口，将JavaBean序列化为XML，并且能够将XML文件反向转换为JavaBean。
*
* @version: v1.0.0
* @author: hujian3
* @date: Sep 25, 2013 7:04:41 PM 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* Sep 25, 2013     hujian3           v1.0.0               修改原因
 */
@SuppressWarnings({"unchecked"})
public class XStreamUtil {
	
	public static final String ESB_SYS_OP_ID = "20057971"; //ESB sysOPId --10010852   SCRM生产工号20057971   准发布可用工号20037686
	public static final String ESB_SYS_PASSWORD = "8323f15343239abb72885940220a4f3e"; 
	
	/**
	 * 
	* @Function: convertJavaBeanToXml
	* @Description: 将JavaBean序列化为XML
	*
	* @param: Object  JavaBean对象  
	* @return：String  xml字符串
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: hujian3
	* @date: Sep 25, 2013 7:09:08 PM 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* Sep 25, 2013     hujian3           v1.0.0               修改原因
	 */
	public static String toXml(Object obj){
		XStream xstream = new XStream();
		xstream.processAnnotations(obj.getClass());
		xstream.aliasSystemAttribute(null, "class");
		String xmlStr = xstream.toXML(obj);
		xmlStr = xmlStr.toUpperCase();
		return xmlStr;
	}
	
	/**
	 *  将传入xml文本转换成Java对象
	 * @Title: toBean 
	 * @Description: 
	 * @param xmlStr
	 * @param cls  xml对应的class类
	 * @return T   xml对应的class类的实例对象
	 * 
	 * 调用的方法实例：PersonBean person=XmlUtil.toBean(xmlStr, PersonBean.class);
	 */
	public static <T> T  toBean(String xmlStr,Class<T> cls){
		XStream xstream=new XStream(new DomDriver());
	    xstream.processAnnotations(cls);
	    T obj=(T)xstream.fromXML(xmlStr);
	    return obj;            
	}
	
	
	/**
	 * 
	* @Function: getEsbReqXml
	* @Description: 根据BUSI_INFO对象,创建esb的输入报文
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: hujian3
	* @date: Nov 1, 2013 2:48:36 PM 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* Nov 1, 2013     hujian3           v1.0.0               修改原因
	 */
	
	public static String getEsbReqXml(Object busiInfo) throws Exception {
		StringBuffer sb = new StringBuffer();
		//BUSI_INFO
		String strBusiInfo ="";
		if(busiInfo !=null){
			 strBusiInfo = XmlnodelUtil.getXmlFromBean(busiInfo);
			 strBusiInfo = strBusiInfo.substring(strBusiInfo.indexOf("<BUSI_INFO"));
		}else{
			//20140905 BUSI_INFO为空的情况下，需要增加一个空的BUSI_INFO节点
			strBusiInfo ="<BUSI_INFO/>";
		}
		//去掉报文头
		 //不使用<BUSI_INFO> 为了解决 <BUSI_INFO/> 的情况   --addby lirn3 strBusiInfo.indexOf 寻找第一次出现的位置，故无风险
		sb.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb.append("<REQ_PARAM>");
		sb.append(getPubInfo());
		sb.append(strBusiInfo);
		sb.append("</REQ_PARAM>");
		return sb.toString();
	}
	
	
	
	/**
	 * 
	* @Function: getPubInfo
	* @Description: 创建esb的输入报文中的PUB_INFO部分,
	*
	* @param:参数描述
	* @return：返回结果描述
	* @throws：异常描述
	*
	* @version: v1.0.0
	* @author: hujian3
	* @date: Nov 1, 2013 2:48:36 PM 
	*
	* Modification History:
	* Date         Author          Version            Description
	*---------------------------------------------------------*
	* Nov 1, 2013     hujian3           v1.0.0               修改原因
	 */
	public static String getPubInfo() throws Exception {
		String strPubInfo = "";
		PUB_INFO pubInfo = new PUB_INFO();
		pubInfo.setSYS_OP_ID(ESB_SYS_OP_ID);
		pubInfo.setSYS_PASSWORD(ESB_SYS_PASSWORD);
		//需修改成前台传入的用户和机构参数
		pubInfo.setOP_ID("10013691");
		pubInfo.setOP_ORG_ID("15");
		
		strPubInfo = XmlnodelUtil.getXmlFromBean(pubInfo);
		return strPubInfo.substring(strPubInfo.indexOf("<PUB_INFO>"));
	}
	
	public static String getPubInfo(String opId,String opOrgId) throws Exception {
		String strPubInfo = "";
		PUB_INFO pubInfo = new PUB_INFO();
		pubInfo.setSYS_OP_ID(ESB_SYS_OP_ID);
		pubInfo.setSYS_PASSWORD(ESB_SYS_PASSWORD);
		//需修改成前台传入的用户和机构参数
		pubInfo.setOP_ID(opId);
		pubInfo.setOP_ORG_ID(opOrgId );
		
		strPubInfo = XmlnodelUtil.getXmlFromBean(pubInfo);
		return strPubInfo.substring(strPubInfo.indexOf("<PUB_INFO>"));
	}

	
}
