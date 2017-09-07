package com.crm.flowdetail.pojo;

import java.io.Serializable;

import com.crm.cfgdata.base.domain.InputCommonData;
//@SuppressWarnings("serial")
public class InputAppDayFlowDO extends InputCommonData implements Serializable{
	
	private String BILL_ID;
	private String QUERY_DATE;
	private String FLOW_TOTAL;
	private String SUM_TYPE;
	private Integer TOP_AMOUNT;
	private String APP_CODE;
	private String COUNT;
	public String getCOUNT() {
		return COUNT;
	}
	public void setCOUNT(String cOUNT) {
		COUNT = cOUNT;
	}
	public String getAPP_CODE() {
		return APP_CODE;
	}
	public void setAPP_CODE(String aPP_CODE) {
		APP_CODE = aPP_CODE;
	}
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
	public String getSUM_TYPE() {
		return SUM_TYPE;
	}
	public void setSUM_TYPE(String sUM_TYPE) {
		SUM_TYPE = sUM_TYPE;
	}
	public Integer getTOP_AMOUNT() {
		return TOP_AMOUNT;
	}
	public void setTOP_AMOUNT(Integer tOP_AMOUNT) {
		TOP_AMOUNT = tOP_AMOUNT;
	}
	
	
}
