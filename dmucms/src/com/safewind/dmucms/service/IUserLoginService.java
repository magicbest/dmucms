package com.safewind.dmucms.service;

import java.util.List;


public interface IUserLoginService<T> {
	   public T getUserInfo(Integer userId) ;
	   public List<T> getUserList() ;
	   public Integer checkUserLoginInfo(String id, String password);
}
