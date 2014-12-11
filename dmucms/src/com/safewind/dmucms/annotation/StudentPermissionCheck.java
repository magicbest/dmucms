package com.safewind.dmucms.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface StudentPermissionCheck {

    /**
     * 是否是项目负责人
     * 
     * @return
     */
    boolean isProjectMannagerCheck() default true;

    /**
     * 1 级权限 学生 2 级权限 指导教师 3 级权限 教学院长 4 级权限 中心权限(最高权限)
     */
    int permissionLevel() default 1;
}
