package com.julie.mikaelson.common.user.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "ts_common_user")
public class User  {
	
	private String username ;
	private String password ;
	private String account ;
	private String phone ;
	private String email ;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id ;

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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public User(String username, String password, String account, String phone,
			String email, Long id) {
		super();
		this.username = username;
		this.password = password;
		this.account = account;
		this.phone = phone;
		this.email = email;
		this.id = id;
	}
	public User(String username, String password, String account, String phone,
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.account = account;
		this.phone = phone;
		this.email = email;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", account=" + account + ", phone=" + phone + ", email="
				+ email + ", id=" + id + "]";
	}
	
	
	
}
