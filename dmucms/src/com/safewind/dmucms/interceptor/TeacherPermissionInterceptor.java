package com.safewind.dmucms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.safewind.dmucms.annotation.TeacherPermissionCheck;
import com.safewind.dmucms.util.UserAccoutUtil;


public class TeacherPermissionInterceptor extends HandlerInterceptorAdapter{
    
    private static final Logger logger = LoggerFactory.getLogger(TeacherPermissionInterceptor.class);
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod method = (HandlerMethod) handler;
        TeacherPermissionCheck permissionCheck = method.getMethodAnnotation(TeacherPermissionCheck.class);
        String userId = UserAccoutUtil.getUserLoginId();
        
        if (permissionCheck == null) {
            logger.info("--- 请求未声明权限 ， 自动放行 ---- ");
            if(userId.length() != 8)
            {
                StringBuilder sbder = new StringBuilder();
                sbder.append(request.getContextPath()).append("/permissionDenied?permissionErrorType=").append("denied");
                response.sendRedirect(sbder.toString());
                return false;
            }
            return true;
        }else {
              HttpSession session = request.getSession();
              
              
              if(userId.length() != 8)
              {
                  StringBuilder sbder = new StringBuilder();
                  sbder.append(request.getContextPath()).append("/permissionDenied?permissionErrorType=").append("denied");
                  response.sendRedirect(sbder.toString());
                  return false;
              }else {
                  
                  if(session.getAttribute("isProjectTeacher") == null)
                  {
                      //强制 获取 session
                      response.sendRedirect(request.getContextPath());
                      return false ;
                  }else{
                      boolean isProjectTeacher =  (boolean) session.getAttribute("isProjectTeacher");
                      int teacherPermissionLevel = (int) session.getAttribute("userRoleLevel"); 
                      if(isProjectTeacher != true || teacherPermissionLevel <  permissionCheck.permissionLevel())
                      {
                          StringBuilder sbder = new StringBuilder();
                          sbder.append(request.getContextPath()).append("/permissionDenied?permissionErrorType=").append("denied");
                          response.sendRedirect(sbder.toString());
                          return false;
                      }else {
                          return true;
                    }
                  }
            }
        }
    }
}
