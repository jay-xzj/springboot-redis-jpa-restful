package com.crm.flowdetail.pojo;

import java.io.Serializable;

import com.crm.cfgdata.base.domain.InputCommonData;

@SuppressWarnings("serial")
public class InputQueryFlowDetailDO extends InputCommonData implements Serializable{

	private String startDate;
	private String endDate;
	private String billId;
	private String pageIndex;
	private String pageSize;
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(String pageIndex) {
		this.pageIndex = pageIndex;
	}
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	
}
