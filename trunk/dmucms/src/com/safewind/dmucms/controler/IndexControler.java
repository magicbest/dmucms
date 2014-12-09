package com.safewind.dmucms.controler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.safewind.dmucms.service.IAppalicationService;
import com.safewind.dmucms.util.UserAccoutUtil;


@Controller
public class IndexControler {
	
	    @Autowired
	    private IAppalicationService AppalicationServiceImpl ;
	
	   @RequestMapping(value = {"/" , "/index"}, method = RequestMethod.GET)
	   public String getLoginPage(HttpSession session)
	   {
		   String  userId = UserAccoutUtil.getUserLoginId();
		   if(userId.length() == 8)
		   {
			   return "teacher/index";
		   }else{
			   int isProjectMannager = AppalicationServiceImpl.getStudentInputFlag(userId);
			   if(isProjectMannager != 0)
			   {
				   session.setAttribute("userRoleLevel", 1);
				   session.setAttribute("isProjectMannager", true);
			   }
			   else {
				   session.setAttribute("userRoleLevel", 1);
				   session.setAttribute("isProjectMannager", false);
			   }
			   return "student/index";
		   }
	   }
	   
	   
	   @RequestMapping(value = "/permissionDenied", method = RequestMethod.GET)
	   public String permissionCheckFail(
			      @RequestParam(value="permissionErrorType") String permissionErrorType , Model model
			   )
	   {
		   if(permissionErrorType.equals("grade4"))
		   {
			   model.addAttribute("permissionInfo", "大四学生不能申报项目，敬请谅解！");
		   }
		   else if(permissionErrorType.equals("denied")){
			   model.addAttribute("permissionInfo", "对不起,您的权限还不能进行此项操作！");
		  }
		   return "fail/permission_denied";
	   }

}