package com.bookchigo.domain;

import org.springframework.web.bind.annotation.RequestParam;

public class Member {
	private int memberId;
	private String username;
	private String email;
	private String password;
	private String name;
	private String address;
	private String phone;
	private String account;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", name=" + name + ", address=" + address + ", phone=" + phone + ", account=" + account + "]";
	}
	
}
