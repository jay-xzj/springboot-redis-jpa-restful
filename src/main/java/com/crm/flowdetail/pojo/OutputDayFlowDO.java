package com.crm.flowdetail.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OutputDayFlowDO implements Serializable{

	private String DAY;
	private int FLOW_DAY;
	public int getFLOW_DAY() {
		return FLOW_DAY;
	}
	public void setFLOW_DAY(int fLOW_DAY) {
		FLOW_DAY = fLOW_DAY;
	}
	public String getDAY() {
		return DAY;
	}
	public String getDAY_FLOW() {
		return DAY_FLOW;
	}
	public void setDAY(String dAY) {
		DAY = dAY;
	}
	public void setDAY_FLOW(String dAY_FLOW) {
		DAY_FLOW = dAY_FLOW;
	}
	private String DAY_FLOW;
	
	
}
