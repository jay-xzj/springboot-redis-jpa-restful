package com.crm.flowdetail.pojo;

import com.crm.cfgdata.base.domain.InputCommonData;

@SuppressWarnings("serial")
public class InputVerificationModeDO extends InputCommonData{
	private String OUT_SYSTEM;//外部系统编码
	private String METHOD;//调用方法
	private String QUERY_TYPE;//类型
	private String BILL_ID;//受理号码
	private String REMARK;//备注
	public String getOUT_SYSTEM() {
		return OUT_SYSTEM;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	public void setOUT_SYSTEM(String oUT_SYSTEM) {
		OUT_SYSTEM = oUT_SYSTEM;
	}
	public String getMETHOD() {
		return METHOD;
	}
	public void setMETHOD(String mETHOD) {
		METHOD = mETHOD;
	}
	public String getQUERY_TYPE() {
		return QUERY_TYPE;
	}
	public void setQUERY_TYPE(String qUERY_TYPE) {
		QUERY_TYPE = qUERY_TYPE;
	}
	public String getBILL_ID() {
		return BILL_ID;
	}
	public void setBILL_ID(String bILL_ID) {
		BILL_ID = bILL_ID;
	}
	
	
	

}
