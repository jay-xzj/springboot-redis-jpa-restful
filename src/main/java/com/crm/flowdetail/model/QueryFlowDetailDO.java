package com.crm.flowdetail.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class QueryFlowDetailDO implements Serializable{
	
	private String HOURS;
	private String FIRST_APPLY;
	private String SECOND_APPLY;
	private String IP;
	private String FLOW;
	
	public String getHOURS() {
		return HOURS;
	}
	public void setHOURS(String hOURS) {
		HOURS = hOURS;
	}
	public String getFIRST_APPLY() {
		return FIRST_APPLY;
	}
	public void setFIRST_APPLY(String fIRST_APPLY) {
		FIRST_APPLY = fIRST_APPLY;
	}
	public String getSECOND_APPLY() {
		return SECOND_APPLY;
	}
	public void setSECOND_APPLY(String sECOND_APPLY) {
		SECOND_APPLY = sECOND_APPLY;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public String getFLOW() {
		return FLOW;
	}
	public void setFLOW(String fLOW) {
		FLOW = fLOW;
	}
}
