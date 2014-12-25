package com.safewind.dmucms.service;

import java.util.List;

import com.safewind.dmucms.model.CollegeProjectSearchParm;
import com.safewind.dmucms.model.CollegeReview;
import com.safewind.dmucms.model.ProjectInfoForCollege;

public interface ICollegeService {

    List<ProjectInfoForCollege> getProjectListByCollege(CollegeProjectSearchParm searchParm);

    void saveProjectCollegeStatus(CollegeReview collegeReview);

	int getProjectCount(String collegeName);

	String getMasterCollegeName(String userId);

}
