package com.safewind.dmucms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safewind.dmucms.dao.CollegeDao;
import com.safewind.dmucms.model.CollegeProjectSearchParm;
import com.safewind.dmucms.model.CollegeReview;
import com.safewind.dmucms.model.ProjectInfoForCollege;
import com.safewind.dmucms.service.ICollegeService;

@Service
public class CollegeServiceImpl implements ICollegeService {
    
    @Autowired 
    private CollegeDao collegeDao ;

    @Override
    public List<ProjectInfoForCollege> getProjectListByCollege(CollegeProjectSearchParm searchParm) {
        return collegeDao.queryProjectListByCollege(searchParm);
    }

    @Override
    public void saveProjectCollegeStatus(CollegeReview collegeReview) {
          collegeDao.updateProjectCollegeStatus(collegeReview) ;
    }

	@Override
	public int getProjectCount(String collegeName)
	{
		return collegeDao.getProjectCount(collegeName);
	}

}
