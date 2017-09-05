package com.crm.flowdetail.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OutPutFlowMostInfoDO implements Serializable{

	private String FLOW_MOST;//柱状图左侧阈值

	public String getFLOW_MOST() {
		return FLOW_MOST;
	}

	public void setFLOW_MOST(String fLOW_MOST) {
		FLOW_MOST = fLOW_MOST;
	}
	
	
}
