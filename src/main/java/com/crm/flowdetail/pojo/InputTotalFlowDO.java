package com.crm.flowdetail.pojo;

import java.io.Serializable;

import com.crm.cfgdata.base.domain.InputCommonData;

public class InputTotalFlowDO extends InputCommonData implements Serializable{

	private String BILL_ID;
	private String QUERY_DATE;

	
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
	
}

