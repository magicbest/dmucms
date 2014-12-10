package com.safewind.dmucms.domain;

import java.io.Serializable;

public class User implements Serializable {
    
    private static final long serialVersionUID = 9042140107612396113L;
    
    private Integer userId ;
	private String  userName ;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
