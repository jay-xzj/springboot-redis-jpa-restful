package com.crm.flowdetail.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OutputDayAndHourFlowListDO  implements Serializable{

	private Integer FLOW_TOTAL;
	public Integer getFLOW_TOTAL() {
		return FLOW_TOTAL;
	}
	public Integer getAMOUNT() {
		return AMOUNT;
	}
	public void setFLOW_TOTAL(Integer fLOW_TOTAL) {
		FLOW_TOTAL = fLOW_TOTAL;
	}
	public void setAMOUNT(Integer aMOUNT) {
		AMOUNT = aMOUNT;
	}
	private Integer AMOUNT;
	private List<com.crm.flowdetail.pojo.OutputDayAndHourFlowDO> APP_FLOW_LIST;
	
	public List<com.crm.flowdetail.pojo.OutputDayAndHourFlowDO> getAPP_FLOW_LIST() {
		return APP_FLOW_LIST;
	}
	public void setAPP_FLOW_LIST(List<com.crm.flowdetail.pojo.OutputDayAndHourFlowDO> APP_FLOW_LIST) {
		this.APP_FLOW_LIST = APP_FLOW_LIST;
	}
	
}
