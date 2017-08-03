package com.crm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "sys_param")
@IdClass(SysParamPK.class)
public class SysParam implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false)
	private String paramCode;
	@Id
	@Column(nullable = false)
	private String paramKey;
	
	@Column(nullable = true)
	private String paramDesc;
	@Column(nullable = false)
	private String paramValue;
	@Column(nullable =false)
	private String regTime;
	
	public String getParamDesc() {
		return paramDesc;
	}
	
	public String getParamValue() {
		return paramValue;
	}
	public String getRegTime() {
		return regTime;
	}
	
	public void setParamDesc(String paramDesc) {
		this.paramDesc = paramDesc;
	}
	
	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	public String getParamCode() {
		return paramCode;
	}

	public String getParamKey() {
		return paramKey;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public void setParamKey(String paramKey) {
		this.paramKey = paramKey;
	}	

}
