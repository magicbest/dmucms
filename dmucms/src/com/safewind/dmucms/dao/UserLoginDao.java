package com.safewind.dmucms.dao;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.Mapper;

@Mapper
public interface UserLoginDao<T> {

	T checkUserLogin(@Param("userId")Integer userId);

	Integer checkUserLoginInfo(@Param("id")String id, @Param("password")String password);

}
