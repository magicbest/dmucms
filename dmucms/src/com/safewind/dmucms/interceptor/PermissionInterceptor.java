package com.safewind.dmucms.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.safewind.dmucms.annotation.PermissionCheck;
import com.safewind.dmucms.util.UserAccoutUtil;

public class PermissionInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(PermissionInterceptor.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userId = UserAccoutUtil.getUserLoginId();

        HandlerMethod method = (HandlerMethod) handler;
        PermissionCheck permissionCheck = method.getMethodAnnotation(PermissionCheck.class);

        if (permissionCheck == null) {
            logger.info(" 没有申明权限 ,  所有级别权限放行  ！ ");
            if (userId.substring(0, 6).equals("222011")) {
                logger.info("----对大四学生进行请求隔离----");
                StringBuilder sb = new StringBuilder();
                sb.append(request.getContextPath()).append("/permissionDenied?permissionErrorType=").append("grade4");
                response.sendRedirect(sb.toString());
                return false;
            } else {
                return true;
            }
        } else {
            if (userId.substring(0, 6).equals("222011")) {
                logger.info("----对大四学生进行请求隔离----");
                StringBuilder sb = new StringBuilder();
                sb.append(request.getContextPath()).append("/permissionDenied?permissionErrorType=").append("grade4");
                response.sendRedirect(sb.toString());
                return false;
            } else {

                HttpSession session = request.getSession();
                if (session.getAttribute("userRoleLevel") == null) {
                    // 强制前往 / 根请求 , 获取用户权限
                    response.sendRedirect(request.getContextPath());
                    return false;
                } else {
                    int userRoleLevel = (int) session.getAttribute("userRoleLevel");
                    boolean isProjectMannager = (boolean) session.getAttribute("isProjectMannager");
                    logger.info("当前用户 : " + userId + "  session中是否为负责人 ： " + isProjectMannager);
                    if (userRoleLevel < permissionCheck.permissionLevel()
                            || !(permissionCheck.isProjectMannagerCheck() == isProjectMannager)) {
                        StringBuilder sbder = new StringBuilder();
                        sbder.append(request.getContextPath()).append("/permissionDenied?permissionErrorType=").append("denied");
                        response.sendRedirect(sbder.toString());
                        return false;
                    } else {
                        return true;
                    }

                }
            }
        }
    }
}
