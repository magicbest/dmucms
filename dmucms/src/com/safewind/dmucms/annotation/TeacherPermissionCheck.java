package com.safewind.dmucms.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface TeacherPermissionCheck {
    /**
     * 是否是项目指导教师
     * @return
     */
    boolean isProjectTeacher() default true;
    
    /**
     * 权限水平
     * @return
     */
    int permissionLevel() default 2;
    
}
