package com.safewind.dmucms.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safewind.dmucms.util.UserAccoutUtil;


@Controller
public class IndexControler {
	
	   @RequestMapping(value = {"/" , "/index"}, method = RequestMethod.GET)
	   public String getLoginPage()
	   {
		   String  userId = UserAccoutUtil.getUserLoginId();
		   if(userId.length() == 8)
		   {
			   return "teacher/index";
		   }else{
			   return "student/index";
		   }
	   }

}