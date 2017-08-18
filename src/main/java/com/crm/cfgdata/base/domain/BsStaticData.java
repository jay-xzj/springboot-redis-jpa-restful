package com.crm.cfgdata.base.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.crm.comm.domain.SysParamPK;

@Entity(name = "BS_STATIC_DATA")
@IdClass(BsStaticDataPK.class)
public class BsStaticData implements Serializable{
	
		private static final long serialVersionUID = 1L;
		
		@Id
		@Column(nullable = false)
		private String codeType;

		@Id
		@Column(nullable = false)
		private String codeValue;

		@Column(nullable = false)
		private String codeName;
		
		@Column(nullable = true)
		private String codeDesc;
		
		@Column(nullable =true)
		private String codeTypeAlias;
		
		@Column(nullable =true)
		private Integer sortId;
		
		@Column(nullable =false)
		private String state;
		
		@Column(nullable =true)
		private String externCodeType;

		public String getCodeType() {
			return codeType;
		}

		public String getCodeValue() {
			return codeValue;
		}

		public String getCodeName() {
			return codeName;
		}

		public String getCodeDesc() {
			return codeDesc;
		}

		public String getCodeTypeAlias() {
			return codeTypeAlias;
		}

		public Integer getSortId() {
			return sortId;
		}

		public String getState() {
			return state;
		}

		public String getExternCodeType() {
			return externCodeType;
		}

		public void setCodeType(String codeType) {
			this.codeType = codeType;
		}

		public void setCodeValue(String codeValue) {
			this.codeValue = codeValue;
		}

		public void setCodeName(String codeName) {
			this.codeName = codeName;
		}

		public void setCodeDesc(String codeDesc) {
			this.codeDesc = codeDesc;
		}

		public void setCodeTypeAlias(String codeTypeAlias) {
			this.codeTypeAlias = codeTypeAlias;
		}

		public void setSortId(Integer sortId) {
			this.sortId = sortId;
		}

		public void setState(String state) {
			this.state = state;
		}

		public void setExternCodeType(String externCodeType) {
			this.externCodeType = externCodeType;
		}
		
		
		
		

	

}
