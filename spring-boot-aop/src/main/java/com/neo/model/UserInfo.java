package com.neo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false)
	private String passWord;
	@Column(nullable = false)
	private String email;
	@Column(nullable = true)
	private String nickName;
	@Column(nullable = false)
	private String regTime;

	public UserInfo() {
		super();
	}
	public UserInfo(String nickName, String email, String userName, String passWord, String regTime) {
		super();
		this.email = email;
		this.nickName = nickName;
		this.passWord = passWord;
		this.userName = userName;
		this.regTime = regTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRegTime() {
		return regTime;
	}
	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}

	@Override
	public String toString() {
		return "UserInfo{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", passWord='" + passWord + '\'' +
				", email='" + email + '\'' +
				", nickName='" + nickName + '\'' +
				", regTime='" + regTime + '\'' +
				'}';
	}
}