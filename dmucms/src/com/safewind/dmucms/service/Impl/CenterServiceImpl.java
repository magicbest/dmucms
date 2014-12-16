package com.safewind.dmucms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safewind.dmucms.dao.CenterDao;
import com.safewind.dmucms.model.CenterReview;
import com.safewind.dmucms.model.ProjectInfoForCenter;
import com.safewind.dmucms.service.ICenterService;

@Service
public class CenterServiceImpl  implements ICenterService {
    
    @Autowired
    private CenterDao centerDao ;
    
    @Override
    public int getProjectCount() {
        return centerDao.queryProjectCount();
    }

    @Override
    public List<ProjectInfoForCenter> getAllProjectList(int startRow, int endRow) {
        return centerDao.queryAllProjectByCenter(startRow,endRow);
    }

    @Override
    public void saveProjectCenterReview(CenterReview centerReview) {
        centerDao.saveProjectCenterReviewResult(centerReview);
    }

}
