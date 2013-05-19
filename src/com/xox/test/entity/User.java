package com.xox.test.entity;

import java.io.Serializable;
/**
 * 测试javabean类
 */
public class User implements Serializable{

	private static final long serialVersionUID = -7467478361581531276L;
	private String id;
	private String userName; 
	private String sex;
	private String password;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
