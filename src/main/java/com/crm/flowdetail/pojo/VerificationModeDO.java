package com.crm.flowdetail.pojo;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

@SuppressWarnings("serial")
public class VerificationModeDO implements Serializable{
	private String RESULT;//返回结果
	private String SHOWSERIALNO;//流水号
	private String MESSAGE;//
	
	
	
	
	
	public String getRESULT() {
		return RESULT;
	}





	public void setRESULT(String rESULT) {
		RESULT = rESULT;
	}





	public String getSHOWSERIALNO() {
		return SHOWSERIALNO;
	}





	public void setSHOWSERIALNO(String sHOWSERIALNO) {
		SHOWSERIALNO = sHOWSERIALNO;
	}





	public String getMESSAGE() {
		return MESSAGE;
	}





	public void setMESSAGE(String mESSAGE) {
		MESSAGE = mESSAGE;
	}





	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
