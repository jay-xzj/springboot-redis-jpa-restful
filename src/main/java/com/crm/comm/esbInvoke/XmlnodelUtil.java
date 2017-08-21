package esbInvoke;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@SuppressWarnings({"unchecked"})
public class XmlnodelUtil {
	
	//存放bean的 marshal和unmarshal的方法，提高速度。(bean的getMethod方法比较耗性能)
	private static ConcurrentHashMap MARSHAL_METHOD_MAP = new ConcurrentHashMap();
	private static ConcurrentHashMap UNMARSHAL_METHOD_MAP = new ConcurrentHashMap();
	
	
	public static Object getBeanFromXml(String xml ,Class xmlBeanClass)
			throws Exception {
		Method method = (Method)UNMARSHAL_METHOD_MAP.get(xmlBeanClass.getName()); 
		
		if(method == null){
			method = xmlBeanClass.getMethod("unmarshal", new Class[]{Reader.class});
			UNMARSHAL_METHOD_MAP.put(xmlBeanClass.getName(), method);
		}
		StringReader stringReader = new StringReader(xml);
		
		return method.invoke(null, new Object[]{stringReader});
		
	}
	
	/**
	 * 将输入参数对象转换成xml
	 * 
	 * @param xmlModelBean
	 * @return
	 * @throws Exception
	 */
	public static String getXmlFromBean(Object xmlModelBean)
			throws Exception {
		Method method =(Method)MARSHAL_METHOD_MAP.get(xmlModelBean.getClass().getName()); 
		
		if(method == null){
			method = xmlModelBean.getClass().getMethod("marshal", new Class[]{Writer.class});
			MARSHAL_METHOD_MAP.put(xmlModelBean.getClass().getName(), method);
		}
		StringWriter stringWriter = new StringWriter();
		
		method.invoke(xmlModelBean, new Object[]{stringWriter});
		
		return stringWriter.toString();
	}

}
