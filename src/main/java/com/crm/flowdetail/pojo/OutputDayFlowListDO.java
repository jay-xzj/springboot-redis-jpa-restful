package com.crm.flowdetail.pojo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class OutputDayFlowListDO  implements Serializable{

	private List<com.crm.flowdetail.pojo.OutputDayFlowDO> FLOW_DAY_LIST;//每日流量
	private Integer FLOW_TOTAL;//已使用总流量
	private Integer AMOUNT;
	public Integer getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(Integer aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public Integer getFLOW_TOTAL() {
		return FLOW_TOTAL;
	}
	public Integer getPAY_FLOW() {
		return PAY_FLOW;
	}
	public Integer getFREE_FLOW() {
		return FREE_FLOW;
	}
	public void setFLOW_TOTAL(Integer fLOW_TOTAL) {
		FLOW_TOTAL = fLOW_TOTAL;
	}
	public void setPAY_FLOW(Integer pAY_FLOW) {
		PAY_FLOW = pAY_FLOW;
	}
	public void setFREE_FLOW(Integer fREE_FLOW) {
		FREE_FLOW = fREE_FLOW;
	}
	private Integer PAY_FLOW;//套餐外流量
	private Integer FREE_FLOW;//套餐内流量
	
	
	public List<com.crm.flowdetail.pojo.OutputDayFlowDO> getFLOW_DAY_LIST() {
		return FLOW_DAY_LIST;
	}
	public void setFLOW_DAY_LIST(List<com.crm.flowdetail.pojo.OutputDayFlowDO> fLOW_DAY_LIST) {
		FLOW_DAY_LIST = fLOW_DAY_LIST;
	}
	
	
	
	
}
