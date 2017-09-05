package com.crm.flowdetail.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OutputQueryFlowDetailDO implements Serializable {

	private String RESULT_COUNT;
	private List<QueryFlowDetailDO> FLOW_LIST;
	
	public String getRESULT_COUNT() {
		return RESULT_COUNT;
	}
	public void setRESULT_COUNT(String rESULT_COUNT) {
		RESULT_COUNT = rESULT_COUNT;
	}
	public List<QueryFlowDetailDO> getFLOW_LIST() {
		return FLOW_LIST;
	}
	public void setFLOW_LIST(List<QueryFlowDetailDO> fLOW_LIST) {
		FLOW_LIST = fLOW_LIST;
	}
}
