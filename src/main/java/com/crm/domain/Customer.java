package com.crm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "sys_customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue
	private Long customerId;
	
	@Column(nullable = false)
	private String customerName;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String certId;
	@Column(nullable = false)
	private String certType;
	
	public Long getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getPassword() {
		return password;
	}
	public String getCertId() {
		return certId;
	}
	public String getCertType() {
		return certType;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public void setCertType(String certType) {
		this.certType = certType;
	}
}
