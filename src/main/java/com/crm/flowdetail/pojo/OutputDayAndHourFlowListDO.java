package com.crm.flowdetail.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OutputDayAndHourFlowListDO  implements Serializable{

	private String COUNT;
	private List<com.crm.flowdetail.pojo.OutputDayAndHourFlowDO> APP_FLOW_LIST;
	
	public List<com.crm.flowdetail.pojo.OutputDayAndHourFlowDO> getAPP_FLOW_LIST() {
		return APP_FLOW_LIST;
	}
	public void setAPP_FLOW_LIST(List<com.crm.flowdetail.pojo.OutputDayAndHourFlowDO> APP_FLOW_LIST) {
		this.APP_FLOW_LIST = APP_FLOW_LIST;
	}
	public String getCOUNT() {
		return COUNT;
	}
	public void setCOUNT(String cOUNT) {
		COUNT = cOUNT;
	}
}
