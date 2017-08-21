package com.crm.esb.invoke;

import java.sql.Timestamp;

//import com.ai.appframe2.common.SessionManager;
//import com.ai.appframe2.privilege.UserInfoInterface;
//import com.asiainfo.aiccsp2.common.util.CastTimeUtil;
//import com.asiainfo.aiccsp2.common.util.ServiceLogDeal;



public class SoapUtil { 
/**
* 
* @Function: invokeMethod
* @Description: WebClient客户端链接WebService服务器的工具方法
*
* @param: serviceName
* @param: busiInfo    BUSI_INFO对象
* @return java.lang.String
* @throws：抛出Exception
*
* @version: v1.0.0
* @author: zhouqishan
*/
	public static String invokeMethod(String serviceName,Object busiInfo) throws Exception {
		WsClient client = new WsClient(serviceName);
		String returnValue="";
		String reqXml = null;
		
		//TODO LOG相关，时间戳
		//Timestamp startTime = ServiceManager.getIdGenerator().getSysDate();
		//long beginTime = System.currentTimeMillis();
		try {
			reqXml = XStreamUtil.getEsbReqXml(busiInfo);
			returnValue = (String)client.invoke(new Object[] {reqXml});
		} catch (Exception e) {
			returnValue=e.getMessage();
			throw new Exception(e);
		}finally{
			try {
				//TODO
				//记录调用日志
             }catch (Exception e2) {
            	//TODO
 				//记录错误日志
             }
		}
		return returnValue;
	}


}
