package com.crm.flowdetail.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OutputDayFlowDO implements Serializable{

	private String DAY;
	private Integer FLOW_DAY;
	
	public Integer getFLOW_DAY() {
		return FLOW_DAY;
	}
	public void setFLOW_DAY(Integer fLOW_DAY) {
		FLOW_DAY = fLOW_DAY;
	}
	public String getDAY() {
		return DAY;
	}	
	public void setDAY(String dAY) {
		DAY = dAY;
	}
	
}
