package com.safewind.dmucms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.Mapper;

import com.safewind.dmucms.model.CollegeProjectSearchParm;
import com.safewind.dmucms.model.CollegeReview;
import com.safewind.dmucms.model.ProjectInfoForCollege;

@Mapper
public interface CollegeDao {

    List<ProjectInfoForCollege> queryProjectListByCollege(CollegeProjectSearchParm searchParm);

    void updateProjectCollegeStatus(CollegeReview collegeReview);

	int getProjectCount(@Param("collegeName")String collegeName);

	String queryCollegeName(@Param("userId")String userId);

}
