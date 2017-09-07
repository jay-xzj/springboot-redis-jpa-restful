package com.crm.flowdetail.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OutputNewDayFlowListDO implements Serializable{

	private List<OutputNewDayFlowDO> FLOW_APPLY_LIST;//应用使用流量TOP5
	
	public List<OutputNewDayFlowDO> getFLOW_APPLY_LIST() {
		return FLOW_APPLY_LIST;
	}
	public void setFLOW_APPLY_LIST(List<OutputNewDayFlowDO> fLOW_APPLY_LIST) {
		FLOW_APPLY_LIST = fLOW_APPLY_LIST;
	}
	
}
