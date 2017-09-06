package com.crm.flowdetail.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OutputTotalFlowDO implements Serializable{

	private String USED_FLOW;//已使用总流量
	private String FREE_FLOW;//套餐内流量
	public String getFREE_FLOW() {
		return FREE_FLOW;
	}
	public String getPAY_FLOW() {
		return PAY_FLOW;
	}
	public void setFREE_FLOW(String fREE_FLOW) {
		FREE_FLOW = fREE_FLOW;
	}
	public void setPAY_FLOW(String pAY_FLOW) {
		PAY_FLOW = pAY_FLOW;
	}
	private String PAY_FLOW;//套餐外流量
	public String getUSED_FLOW() {
		return USED_FLOW;
	}
	public String getALL_FLOW() {
		return ALL_FLOW;
	}
	public void setUSED_FLOW(String uSED_FLOW) {
		USED_FLOW = uSED_FLOW;
	}
	public void setALL_FLOW(String aLL_FLOW) {
		ALL_FLOW = aLL_FLOW;
	}
	private String ALL_FLOW;//总流量
	
	
	
	
}

