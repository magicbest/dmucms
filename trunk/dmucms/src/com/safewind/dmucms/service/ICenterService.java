package com.safewind.dmucms.service;

import java.util.List;

import com.safewind.dmucms.model.CenterReview;
import com.safewind.dmucms.model.ProjectInfoForCenter;


public interface ICenterService {

    int getProjectCount();

    List<ProjectInfoForCenter> getAllProjectList(int startRow, int endRow);

    void saveProjectCenterReview(CenterReview centerReview);

}
