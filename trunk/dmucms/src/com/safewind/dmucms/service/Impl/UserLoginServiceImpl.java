package com.safewind.dmucms.service.Impl;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.safewind.dmucms.dao.UserLoginDao;
import com.safewind.dmucms.domain.User;
import com.safewind.dmucms.service.IUserLoginService;

@Service
public class UserLoginServiceImpl<T extends User> implements IUserLoginService<T> {
	
	@Autowired
	private UserLoginDao<T> userLoginDao;
	
	
	public T getUserInfo(Integer userId) {
		return (T) userLoginDao.checkUserLogin(userId);
	}

	public List<T> getUserList() {
		return null;
	}

	public Integer checkUserLoginInfo(String id, String password) {
		Integer loginResult = userLoginDao.checkUserLoginInfo(id,password);
		return loginResult;
	}
}
