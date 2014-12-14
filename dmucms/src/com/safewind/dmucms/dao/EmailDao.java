package com.safewind.dmucms.dao;

import java.util.List;

import org.mybatis.spring.annotation.Mapper;

@Mapper
public interface EmailDao {

	List<String> queryAllEmailAdress();

}
