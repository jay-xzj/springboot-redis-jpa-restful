package com.crm.flowdetail.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OutputNewDayFlowListDO implements Serializable{

	private List<OutputNewDayFlowDO> APP_FLOW_LIST;//应用使用流量TOP5

	public List<OutputNewDayFlowDO> getAPP_FLOW_LIST() {
		return APP_FLOW_LIST;
	}

	public void setAPP_FLOW_LIST(List<OutputNewDayFlowDO> aPP_FLOW_LIST) {
		APP_FLOW_LIST = aPP_FLOW_LIST;
	}
	
	
	
}
