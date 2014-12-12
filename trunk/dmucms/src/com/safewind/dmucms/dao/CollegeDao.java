package com.safewind.dmucms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.Mapper;

import com.safewind.dmucms.model.CollegeReview;
import com.safewind.dmucms.model.ProjectInfoForCollege;

@Mapper
public interface CollegeDao {

    List<ProjectInfoForCollege> queryProjectListByCollege(@Param("collegeName")String collegeName);

    void updateProjectCollegeStatus(CollegeReview collegeReview);

}
