package com.crm.flowdetail.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OutputFlowTotalDO implements Serializable{

	private String FLOW_TOTAL;//已使用总流量
	private String PAY_FLOW;//套餐外流量
	private String FREE_FLOW;//套餐内流量
	private String PAY_FLOW_PER;//套餐外流量百分比
	private String FREE_FLOW_PER;//套餐内流量百分比
	
	public String getFLOW_TOTAL() {
		return FLOW_TOTAL;
	}
	public void setFLOW_TOTAL(String fLOW_TOTAL) {
		FLOW_TOTAL = fLOW_TOTAL;
	}
	public String getPAY_FLOW() {
		return PAY_FLOW;
	}
	public void setPAY_FLOW(String pAY_FLOW) {
		PAY_FLOW = pAY_FLOW;
	}
	public String getFREE_FLOW() {
		return FREE_FLOW;
	}
	public void setFREE_FLOW(String fREE_FLOW) {
		FREE_FLOW = fREE_FLOW;
	}
	public String getPAY_FLOW_PER() {
		return PAY_FLOW_PER;
	}
	public void setPAY_FLOW_PER(String pAY_FLOW_PER) {
		PAY_FLOW_PER = pAY_FLOW_PER;
	}
	public String getFREE_FLOW_PER() {
		return FREE_FLOW_PER;
	}
	public void setFREE_FLOW_PER(String fREE_FLOW_PER) {
		FREE_FLOW_PER = fREE_FLOW_PER;
	}
	
	
}
