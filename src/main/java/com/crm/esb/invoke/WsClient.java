package com.crm.esb.invoke;

import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;

import org.apache.axis.AxisProperties;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.ser.ArrayDeserializerFactory;
import org.apache.axis.encoding.ser.ArraySerializerFactory;
import org.apache.axis.encoding.ser.BeanDeserializerFactory;
import org.apache.axis.encoding.ser.BeanSerializerFactory;
import org.apache.axis.utils.StringUtils;

import com.crm.cfgdata.base.domain.CfgWsClient;
import com.crm.esb.invoke.Parameter;

public class WsClient
{

    private static final int DEFAULT_TIMEOUT_SECONDS = 3;
    private CfgWsClient objCfgWsClient;
    private Service service;
    private static int CONCURRENT_CAPACITY;
    private static int CONCURRENT_ACQUIRE_TIMEOUT_SECONDS;
    //TODO 并发容器怎么处理？
    //private static ConcurrentCapacity SEM = null;

    static 
    {
    	//TODO log最后去做
        //log = LogFactory.getLog(com/asiainfo/appframe/ext/exeframe/ws/client/WsClient);
        CONCURRENT_CAPACITY = 15;
        CONCURRENT_ACQUIRE_TIMEOUT_SECONDS = 3;
        AxisProperties.setProperty("axis.http.client.maximum.total.connections", "30");
        AxisProperties.setProperty("axis.http.client.maximum.connections.per.host", "30");
        AxisProperties.setProperty("axis.http.client.connection.pool.timeout", "30");
        AxisProperties.setProperty("axis.http.client.connection.default.connection.timeout", "3000");
        AxisProperties.setProperty("axis.http.client.connection.default.so.timeout", "3000");
        CONCURRENT_CAPACITY = Integer.getInteger("appframe.ws.concurrentCapacity", 15).intValue();
        CONCURRENT_ACQUIRE_TIMEOUT_SECONDS = Integer.getInteger("appframe.ws.concurrentCapacityAcquireTimeoutSeconds", 3).intValue();
        //SEM = new ConcurrentCapacity(CONCURRENT_CAPACITY, CONCURRENT_ACQUIRE_TIMEOUT_SECONDS);
        //log.error((new StringBuilder()).append("ws current capacity:").append(CONCURRENT_CAPACITY).toString());
        //log.error((new StringBuilder()).append("ws current capacity timeout:").append(CONCURRENT_ACQUIRE_TIMEOUT_SECONDS).append(" seconds").toString());
    }

  public WsClient(String cfgWsClientCode)
        throws Exception
    {
    	objCfgWsClient = new CfgWsClient();
        service = null;
        //TODO 换成读取新配置
        objCfgWsClient.setCfgWsClientCode("ESB_CS_QRY_MULTI_MULTIQRY_001");
        objCfgWsClient.setMethodName("http://esb-ownchannel.yw.zj.chinamobile.com;ESB_CS_QRY_MULTI_MULTIQRY_001");
        objCfgWsClient.setMethodParameter("[{'reqXml','http://www.w3.org/2001/XMLSchema;string','IN'}]");
        objCfgWsClient.setMethodRetrurnType("http://www.w3.org/2001/XMLSchema;string");
        objCfgWsClient.setTimeoutSeconds(10L);
        objCfgWsClient.setOperationStyle("rpc");
        objCfgWsClient.setOperationUse("encoded");
        objCfgWsClient.setUrlAddress("http://20.26.3.195:8104/zjboss/proxy/ESB_CS_QRY_MULTI_MULTIQRY_001?wsdl");
        service = new Service();
    }

    public Object invoke(Object params[])
        throws Exception
    {
        boolean isAcquire = false;
        Object obj;
//        isAcquire = SEM.acquire();
//        this;
       Parameter parameters[] = parseString2Parameter(objCfgWsClient.getMethodParameter());
        String tmp[] = StringUtils.split(objCfgWsClient.getMethodRetrurnType(), ';');
        QName qname = new QName(tmp[0], tmp[1]);
        HashMap map = parseString2TypeMapping(objCfgWsClient.getRegisterTypeMapping());
        obj = invoke(parameters, params, qname, map);
//        if(isAcquire)
//            SEM.release();
        return obj;
//        Exception exception;
//        exception;
//        if(isAcquire)
//            SEM.release();
//        throw exception;
    }

    private Object invoke(Parameter parameter[], Object params[], QName returnType, HashMap map)
        throws Exception
    {
        Object rtn = null;
        try
        {
            Call call = (Call)service.createCall();
            if(!org.apache.commons.lang.StringUtils.isBlank(objCfgWsClient.getOperationStyle()))
                call.setOperationStyle(objCfgWsClient.getOperationStyle().trim());
            if(!org.apache.commons.lang.StringUtils.isBlank(objCfgWsClient.getOperationUse()))
                call.setOperationUse(objCfgWsClient.getOperationUse().trim());
            //call.setTimeout(new Integer(objCfgWsClient.getTimeoutSeconds() * 1000));
            Long outTime = objCfgWsClient.getTimeoutSeconds()*1000;
            call.setTimeout(Integer.parseInt(outTime.toString()));
            call.setTargetEndpointAddress(new URL(objCfgWsClient.getUrlAddress()));
            if(org.apache.commons.lang.StringUtils.contains(objCfgWsClient.getMethodName(), ";"))
            {
                String tmp[] = StringUtils.split(objCfgWsClient.getMethodName(), ';');
                QName qn = new QName(tmp[0], tmp[1]);
                call.setOperationName(qn);
                if(tmp[0].trim().endsWith("/"))
                    call.setSOAPActionURI((new StringBuilder()).append(tmp[0]).append(tmp[1]).toString());
                else
                    call.setSOAPActionURI((new StringBuilder()).append(tmp[0]).append("/").append(tmp[1]).toString());
            } else{
                call.setOperationName(objCfgWsClient.getMethodName());
                call.setSOAPActionURI("");
            }
            if(map != null && !map.isEmpty())
            {
                Set set = map.keySet();
                for(Iterator iter = set.iterator(); iter.hasNext();)
                {
                    String item = (String)iter.next();
                    String tmp[] = StringUtils.split(item, ';');
                    QName qn = new QName(tmp[0], tmp[1]);
                    if(tmp[1].startsWith("ArrayOf"))
                    {
                        String str = ((String)map.get(item)).trim();
                        if(str.endsWith(";") && str.startsWith("[L"))
                        {
                            Class clazz = Class.forName(str);
                            call.registerTypeMapping(clazz, qn, new ArraySerializerFactory(clazz, qn), new ArrayDeserializerFactory(qn));
                        } else
                        {
                            throw new Exception((new StringBuilder()).append("\u5B9A\u4E49\u7684\u7C7B\u578B:").append(str).append(",\u5FC5\u987B\u662F\u6570\u7EC4\u7C7B\u578B").toString());
                        }
                    } else
                    {
                        Class clazz = Class.forName((String)map.get(item));
                        call.registerTypeMapping(clazz, qn, new BeanSerializerFactory(clazz, qn), new BeanDeserializerFactory(clazz, qn));
                    }
                }

            }
            for(int i = 0; i < parameter.length; i++)
                call.addParameter(parameter[i].getName(), parameter[i].getType(), parameter[i].getMode());

            call.setUseSOAPAction(true);
            call.setReturnType(returnType);
            rtn = call.invoke(params);
        }
        catch(Exception ex)
        {
        	//TODO
        	//错误日志
        }
        return rtn;
    }


    private static Parameter[] parseString2Parameter(String str)
        throws Exception
    {
        List list = new ArrayList();
        String tmp1[] = getParamFromString(str, "[", "]");
        for(int i = 0; i < tmp1.length; i++)
        {
            String tmp2[] = getParamFromString(tmp1[i], "{", "}");
            for(int j = 0; j < tmp2.length; j++)
            {
                String tmp3[] = getParamFromString(tmp2[j], "'", "'");
                String tmp4[] = StringUtils.split(tmp3[1], ';');
                QName qname = new QName(tmp4[0], tmp4[1]);
                ParameterMode mode = null;
                if(tmp3[2].equalsIgnoreCase("IN"))
                    mode = ParameterMode.IN;
                else
                if(tmp3[2].equalsIgnoreCase("OUT"))
                    mode = ParameterMode.OUT;
                else
                if(tmp3[2].equalsIgnoreCase("INOUT"))
                    mode = ParameterMode.INOUT;
                else
                    throw new Exception((new StringBuilder()).append("\u65E0\u6CD5\u8BC6\u522B\u7684ParameterMode:").append(tmp3[2]).append(",\u76EE\u524D\u53EA\u80FD\u8BC6\u522BIN,INOUT,OUT").toString());
                Parameter parameter = new Parameter(tmp3[0], qname, mode);
                list.add(parameter);
            }

        }

        return (Parameter[])(Parameter[])list.toArray(new Parameter[0]);
    }

    private static HashMap parseString2TypeMapping(String str)
        throws Exception
    {
        HashMap map = new HashMap();
        String tmp1[] = getParamFromString(str, "[", "]");
        for(int i = 0; i < tmp1.length; i++)
        {
            String tmp2[] = getParamFromString(tmp1[i], "{", "}");
            for(int j = 0; j < tmp2.length; j++)
            {
                String tmp3[] = getParamFromString(tmp2[j], "'", "'");
                map.put(tmp3[0], tmp3[1]);
            }

        }

        return map;
    }
    public static String[] getParamFromString(String aSourceString, String aStartStr, String aEndStr)
    {
        aSourceString = (new StringBuilder()).append(aSourceString).append(aEndStr).toString();
        String strSource = aSourceString;
        ArrayList strKey = new ArrayList();
        int iStartIndex = strSource.indexOf(aStartStr);
        int iStartLength = aStartStr.length();
        int iEndLength = aEndStr.length();
        String strTemp = "";
        strTemp = strSource.substring(iStartIndex + iStartLength, strSource.length());
        int iEndIndex = strTemp.indexOf(aEndStr) + strSource.substring(0, iStartIndex + iStartLength).length();
        if(iEndIndex == iStartIndex)
            strKey.add(strTemp);
        for(; iStartIndex != -1 && iEndIndex != -1 && iStartIndex < iEndIndex; iEndIndex = strTemp.indexOf(aEndStr) + strSource.substring(0, iStartIndex + iStartLength).length())
        {
            strTemp = strSource.substring(iStartIndex + iStartLength, iEndIndex);
            strKey.add(strTemp);
            strSource = strSource.substring(iEndIndex + iEndLength, strSource.length());
            iStartIndex = strSource.indexOf(aStartStr);
            strTemp = strSource.substring(iStartIndex + iStartLength, strSource.length());
        }

        return (String[])(String[])strKey.toArray(new String[0]);
    }
	public static void main(String[] args){
		com.crm.esb.invoke.xbean.BUSI_INFO busiInfo = new com.crm.esb.invoke.xbean.BUSI_INFO();
		busiInfo.setBILL_ID("13566369050");
		String returnValue="";
		try{
			WsClient client = new WsClient("ESB_CS_QRY_MULTI_MULTIQRY_003");
			
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
			}
		
		}catch(Exception e){
			System.out.print(e.getMessage());
		}
		System.out.print(returnValue);
	}
}


