package com.crm.cfgdata.base.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class BsStaticDataPK implements Serializable {
	private static final long serialVersionUID = 1L;

	private String codeType;
	private String codeValue;
	
	public BsStaticDataPK() {
		
	}
	
	public BsStaticDataPK(String codeType,String codeValue) {
		this.codeType=codeType;
		this.codeValue=codeValue;
	}
	
	public String getcodeValue() {
		return codeValue;
	}
	
	public String getcodeType() {
		return codeType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codeType == null) ? 0 : codeType.hashCode());
		result = prime * result 
				+ ((codeValue == null) ? 0 : codeValue.hashCode());
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
		BsStaticDataPK other = (BsStaticDataPK) obj;
		if (codeType == null) {
			if (other.codeType != null)
				return false;
		} else if (!codeType.equals(other.codeType))
			return false;
		if (codeValue != other.codeValue)
			return false;
		return true;
	}
	
}
