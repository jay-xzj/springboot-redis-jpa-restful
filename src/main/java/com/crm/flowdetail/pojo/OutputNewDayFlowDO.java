package com.crm.flowdetail.pojo;


import java.io.Serializable;

@SuppressWarnings("serial")
public class OutputNewDayFlowDO  implements Serializable{

	private String NAME;
	private String PERCENT;
	private String AMOUNT;
	private String IS_SHOW;
	private String WIDTH_PERCENT;
	private String APP_CODE;
	
	public String getAPP_CODE() {
		return APP_CODE;
	}
	public void setAPP_CODE(String aPP_CODE) {
		APP_CODE = aPP_CODE;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPERCENT() {
		return PERCENT;
	}
	public void setPERCENT(String pERCENT) {
		PERCENT = pERCENT;
	}
	public String getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(String aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public String getIS_SHOW() {
		return IS_SHOW;
	}
	public void setIS_SHOW(String iS_SHOW) {
		IS_SHOW = iS_SHOW;
	}
	public String getWIDTH_PERCENT() {
		return WIDTH_PERCENT;
	}
	public void setWIDTH_PERCENT(String wIDTH_PERCENT) {
		WIDTH_PERCENT = wIDTH_PERCENT;
	}
}
