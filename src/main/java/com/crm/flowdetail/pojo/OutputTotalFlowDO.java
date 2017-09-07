package com.crm.flowdetail.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OutputTotalFlowDO implements Serializable{

	private Integer USED_FLOW;//已使用总流量
	public Integer getUSED_FLOW() {
		return USED_FLOW;
	}
	public Integer getFREE_FLOW() {
		return FREE_FLOW;
	}
	public Integer getPAY_FLOW() {
		return PAY_FLOW;
	}
	public Integer getALL_FLOW() {
		return ALL_FLOW;
	}
	public void setUSED_FLOW(Integer uSED_FLOW) {
		USED_FLOW = uSED_FLOW;
	}
	public void setFREE_FLOW(Integer fREE_FLOW) {
		FREE_FLOW = fREE_FLOW;
	}
	public void setPAY_FLOW(Integer pAY_FLOW) {
		PAY_FLOW = pAY_FLOW;
	}
	public void setALL_FLOW(Integer aLL_FLOW) {
		ALL_FLOW = aLL_FLOW;
	}
	private Integer FREE_FLOW;//套餐内流量
	private Integer PAY_FLOW;//套餐外流量
	private Integer ALL_FLOW;//总流量
	
	
	
	
}

