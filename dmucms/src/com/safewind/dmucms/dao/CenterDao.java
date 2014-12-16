package com.safewind.dmucms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.safewind.dmucms.model.CenterReview;
import com.safewind.dmucms.model.ProjectInfoForCenter;

public interface CenterDao {

    int queryProjectCount();

    List<ProjectInfoForCenter> queryAllProjectByCenter(@Param("startRow")int startRow, @Param("endRow")int endRow);

    void saveProjectCenterReviewResult(CenterReview centerReview);

}
