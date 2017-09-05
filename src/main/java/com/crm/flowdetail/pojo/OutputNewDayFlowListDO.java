package com.crm.flowdetail.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OutputNewDayFlowListDO implements Serializable{

	private List<OutputNewDayFlowDO> FLOW_DAY_LIST;//每日流量
	private List<OutputNewDayFlowDO> FLOW_APPLY_LIST;//应用使用流量TOP5
	private List<OutPutFlowMostInfoDO> FLOW_MOST_LIST;//柱状图左侧阈值
	private OutputFlowTotalDO FLOW_INFO;
	
	public List<OutputNewDayFlowDO> getFLOW_DAY_LIST() {
		return FLOW_DAY_LIST;
	}
	public void setFLOW_DAY_LIST(List<OutputNewDayFlowDO> fLOW_DAY_LIST) {
		FLOW_DAY_LIST = fLOW_DAY_LIST;
	}
	public List<OutputNewDayFlowDO> getFLOW_APPLY_LIST() {
		return FLOW_APPLY_LIST;
	}
	public void setFLOW_APPLY_LIST(List<OutputNewDayFlowDO> fLOW_APPLY_LIST) {
		FLOW_APPLY_LIST = fLOW_APPLY_LIST;
	}
	public OutputFlowTotalDO getFLOW_INFO() {
		return FLOW_INFO;
	}
	public void setFLOW_INFO(OutputFlowTotalDO fLOW_INFO) {
		FLOW_INFO = fLOW_INFO;
	}
	public List<OutPutFlowMostInfoDO> getFLOW_MOST_LIST() {
		return FLOW_MOST_LIST;
	}
	public void setFLOW_MOST_LIST(List<OutPutFlowMostInfoDO> fLOW_MOST_LIST) {
		FLOW_MOST_LIST = fLOW_MOST_LIST;
	}
}
