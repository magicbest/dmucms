package com.safewind.dmucms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safewind.dmucms.dao.AppalicationDao;
import com.safewind.dmucms.model.Appalication;
import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;
import com.safewind.dmucms.service.IAppalicationService;

@Service
public class AppalicationServiceImpl implements IAppalicationService
{
	@Autowired
	private AppalicationDao  appalicationDao ;
	
	@Override
	public Student getStudentBasicInfo(String studentId)
	{
		Student student = appalicationDao.getStudentBasicInfo(studentId) ; 
		return student;
	}
	
	@Override
	public int saveProjectInfo(Project project) {
		int saveResult = appalicationDao.saveProjectInfo(project);
		return saveResult ;
	}

	@Override
	public int updateAppalication(Appalication appalication) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int getStudentInputFlag(String studentId) {
		return appalicationDao.getStudentInputFlag(studentId);
	}

	@Override
	public void saveTeamInfo(String[] projectMemberId, int projectId , String[]projectMemberWork) {
		for (int i = 1 ; i < projectMemberId.length; i++) {
			appalicationDao.saveTeamInfo(projectId,projectMemberId[i],projectMemberWork[i]);
		}
		
	}

	@Override
	public void saveCostInfo(Cost cost) {
		appalicationDao.saveCostInfo(cost);
	}

	@Override
	public int queryProjectId(String userLoginId) {
		return appalicationDao.queryProjectIdByUserId(userLoginId);
	}

	@Override
	public void saveStudentInfo(Student student) {
		appalicationDao.saveStudentInfo(student);
	}

	@Override
	public Student getStudentTotalInfo(String studentId) {
		return appalicationDao.getStudentTotalInfo(studentId);
	}

	@Override
	public Project getProjectInfo(int projectId) {
		return appalicationDao.getProjectInfo(projectId);
	}

	@Override
	public Cost getCostInfo(int projectId) {
		return appalicationDao.getCostInfo(projectId);
	}

	@Override
	public List<TeamMember> getTeamMemberInfo(int projectId) {
		return appalicationDao.getTeamMemberInfo(projectId);
	}

	@Override
	public void saveBusinessTeacherInfo(BusinessTeacher businessTeacher) {
		appalicationDao.saveBusinessTeacherInfo(businessTeacher);
	}

	@Override
	public BusinessTeacher getBusinessTeacher(int projectId) {
		
		return appalicationDao.getBusinessTeacher(projectId);
	}

}
