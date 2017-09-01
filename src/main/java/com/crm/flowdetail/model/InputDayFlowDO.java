package com.crm.flowdetail.model;

import java.io.Serializable;

import com.crm.cfgdata.base.domain.InputCommonData;

@SuppressWarnings("serial")
public class InputDayFlowDO extends InputCommonData implements Serializable{

	private String BILL_ID;
	private String QUERY_DATE;
	private String FLOW_TOTAL;
	
	public String getBILL_ID() {
		return BILL_ID;
	}
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}
	public String getQUERY_DATE() {
		return QUERY_DATE;
	}
	public void setQUERY_DATE(String qUERY_DATE) {
		QUERY_DATE = qUERY_DATE;
	}
	public String getFLOW_TOTAL() {
		return FLOW_TOTAL;
	}
	public void setFLOW_TOTAL(String fLOW_TOTAL) {
		FLOW_TOTAL = fLOW_TOTAL;
	}
	
}
