package com.crm;



import org.springframework.boot.web.servlet.FilterRegistrationBean;

import org.springframework.context.annotation.Configuration;


import com.crm.comm.filter.SecurityFilter;



@Configuration
public class WebConfiguration{
	
	 public FilterRegistrationBean filterRegistration() {

	        FilterRegistrationBean registration = new FilterRegistrationBean();
	        registration.setFilter(new SecurityFilter());
	        registration.addUrlPatterns("/*");
	        registration.addInitParameter("paramName", "paramValue");
	        registration.setName("MyFilter");
	        registration.setOrder(1);
	        return registration;
	    }
	 
}
	
	


