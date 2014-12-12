package com.safewind.dmucms.service;

import java.util.List;

import com.safewind.dmucms.model.CollegeReview;
import com.safewind.dmucms.model.ProjectInfoForCollege;

public interface ICollegeService {

    List<ProjectInfoForCollege> getProjectListByCollege(String collegeName);

    void saveProjectCollegeStatus(CollegeReview collegeReview);

}
