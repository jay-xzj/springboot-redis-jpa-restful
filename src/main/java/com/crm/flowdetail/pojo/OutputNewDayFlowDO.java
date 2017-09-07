package com.crm.flowdetail.pojo;


import java.io.Serializable;

@SuppressWarnings("serial")
public class OutputNewDayFlowDO  implements Serializable{

	private String APP_NAME;
	public String getAPP_NAME() {
		return APP_NAME;
	}
	public Integer getAPP_FLOW() {
		return APP_FLOW;
	}
	public void setAPP_NAME(String aPP_NAME) {
		APP_NAME = aPP_NAME;
	}
	public void setAPP_FLOW(Integer aPP_FLOW) {
		APP_FLOW = aPP_FLOW;
	}
	private Integer APP_FLOW;
	private String APP_CODE;
	
	public String getAPP_CODE() {
		return APP_CODE;
	}
	public void setAPP_CODE(String aPP_CODE) {
		APP_CODE = aPP_CODE;
	}
	
}
