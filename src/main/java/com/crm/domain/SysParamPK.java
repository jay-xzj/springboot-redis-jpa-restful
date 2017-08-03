package com.crm.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class SysParamPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String paramCode;
	private String paramKey;
	
	public SysParamPK() {
		
	}
	
	public SysParamPK(String paramCode,String paramKey) {
		this.paramCode=paramCode;
		this.paramKey=paramKey;
	}
	
	public String getParamKey() {
		return paramKey;
	}
	
	public String getParamCode() {
		return paramCode;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((paramCode == null) ? 0 : paramCode.hashCode());
		result = prime * result 
				+ ((paramKey == null) ? 0 : paramKey.hashCode());
		return result;
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysParamPK other = (SysParamPK) obj;
		if (paramCode == null) {
			if (other.paramCode != null)
				return false;
		} else if (!paramCode.equals(other.paramCode))
			return false;
		if (paramKey != other.paramKey)
			return false;
		return true;
	}
	
}
