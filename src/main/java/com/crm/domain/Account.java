package com.crm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "sys_account")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, unique = true)
	private String accountNo;
	@Column(nullable = true)
	private String accountPrd;
	@Column(nullable = true)
	private String payType;
	@Column(nullable = true)
	private String openBnk;
	
	public String getAccountNo() {
		return accountNo;
	}
	public String getAccountPrd() {
		return accountPrd;
	}
	public String getPayType() {
		return payType;
	}
	public String getOpenBnk() {
		return openBnk;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public void setAccountPrd(String accountPrd) {
		this.accountPrd = accountPrd;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public void setOpenBnk(String openBnk) {
		this.openBnk = openBnk;
	}
	

}
