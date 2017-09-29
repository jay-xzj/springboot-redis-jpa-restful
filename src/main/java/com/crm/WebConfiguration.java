package com.crm;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.crm.comm.filter.SecurityFilter;
import com.crm.login.filter.PortalFilter;




@Configuration
public class WebConfiguration{
	
	 @Autowired
	 PortalFilter portalFilter;
	 
	 //EXAMPLE
	 /*public FilterRegistrationBean filterRegistration() {
	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(new SecurityFilter());
	        registration.addUrlPatterns("/*");
	        registration.addInitParameter("paramName", "paramValue");
	        registration.setName("MyFilter");
	        registration.setOrder(1);
	        return registration;
	  }*/
	 
	 //4A FILTER
	 @Bean
	 public FilterRegistrationBean portalFirstFilter() {

	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(portalFilter);
	        registration.addUrlPatterns("/*");///auth/4AsignIn/
	        //registration.addUrlPatterns("/auth/4AsignIn/");
	        //本地实现类
	        registration.addInitParameter("impl-classname", "com.crm.login.impl.PopedomImpl");
	        //允许通过的路径
	        registration.addInitParameter("ALLOWPATH", "");
	        registration.addInitParameter("ISLOG", "true");
	        registration.setName("portalfirstfilter");
	        registration.setOrder(1);
	        return registration;
	        
	 }
	 
}
	
	


