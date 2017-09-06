package com.crm.flowdetail.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OutputDayAndHourFlowDO  implements Serializable{

	private String USED_DATE;
	private String FLOW;
	public String getUSED_DATE() {
		return USED_DATE;
	}
	public void setUSED_DATE(String uSED_DATE) {
		USED_DATE = uSED_DATE;
	}
	public String getFLOW() {
		return FLOW;
	}
	public void setFLOW(String fLOW) {
		FLOW = fLOW;
	}

	
	
}
