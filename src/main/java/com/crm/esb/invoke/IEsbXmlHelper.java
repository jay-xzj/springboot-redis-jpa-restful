package com.crm.esb.invoke;



/**
 * @User: mayc
 * @Date: 2014年4月24日
 * @Time: 下午1:45:19
 * @version $Revision: 112 $ $Date: 2015-02-10 19:13:29 +0800 (周二, 10 二月 2015) $
 */
public interface IEsbXmlHelper<T> {

	T parseXml(String xml, Class<T> clz) throws Exception;

	//T parseXml(String xml, Class<T> clz, String pubChildName,String busiChildName) throws Exception;
}


