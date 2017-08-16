package com.crm.comm.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "sys_user")
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long userId;
	@Column(nullable = false, unique = true)
	private String username;
	@Column(nullable = false)
	private Long customerId;
	@Column(nullable = true)
	private String mobileNo;
	@Column(nullable = true)
	private String userStatus;
	@Column(nullable = true)
	private String userType;
	@Column(nullable = true)
	private String address;	
	@Column(nullable = true)
	private String password;
	@Column(nullable = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String nickName;
	@Column(nullable =false)
	private String regTime;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getUserId() {
		return userId;
	}
	public String getEmail() {
		return email;
	}
	public String getNickName() {
		return nickName;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setUserId(Long id) {
		this.userId = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	public Long getUser_id() {
		return userId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public String getUserType() {
		return userType;
	}
	public String getAddress() {
		return address;
	}
	public void setUser_id(Long user_id) {
		this.userId = user_id;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public void setUser_status(String user_status) {
		this.userStatus = user_status;
	}
	public void setUser_type(String user_type) {
		this.userType = user_type;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
