package com.safewind.dmucms.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public  class UserAccoutUtil {
	public static String getUserLoginId() {
		HttpServletRequest request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		String userId =  request.getRemoteUser();
		return userId ;
	}
}
