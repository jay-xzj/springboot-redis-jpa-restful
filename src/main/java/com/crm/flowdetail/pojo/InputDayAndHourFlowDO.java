package com.crm.flowdetail.pojo;

import java.io.Serializable;

import com.crm.cfgdata.base.domain.InputCommonData;

@SuppressWarnings("serial")
public class InputDayAndHourFlowDO extends InputCommonData implements Serializable{
	private String BILL_ID;
	private String QRY_DATE;
	private String APP_CODE;
	private String SUM_TYPE;
	public String getBILL_ID() {
		return BILL_ID;
	}
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}
	public String getQRY_DATE() {
		return QRY_DATE;
	}
	public void setQRY_DATE(String qRY_DATE) {
		QRY_DATE = qRY_DATE;
	}
	public String getAPP_CODE() {
		return APP_CODE;
	}
	public void setAPP_CODE(String aPP_CODE) {
		APP_CODE = aPP_CODE;
	}
	public String getSUM_TYPE() {
		return SUM_TYPE;
	}
	public void setSUM_TYPE(String sUM_TYPE) {
		SUM_TYPE = sUM_TYPE;
	}
	
	
	

}
