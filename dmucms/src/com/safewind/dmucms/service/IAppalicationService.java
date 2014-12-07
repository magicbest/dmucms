package com.safewind.dmucms.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;

public interface IAppalicationService
{
	public Student getStudentBasicInfo(String studentId);

	public void saveProjectInfo(Project project);

	public int getStudentInputFlag(String studentId);

	public void saveTeamInfo(String[] projectMemberId, int projectId,String[]projectMemberWork);

	public void saveCostInfo(Cost cost);

	public int queryProjectId(String userLoginId);

	public void saveStudentInfo(Student student);

	public Student getStudentTotalInfo(String studentId);

	public Project getProjectInfo(int projectId);

	public Cost getCostInfo(int projectId);

	public List<TeamMember> getTeamMemberInfo(int projectId);

	public void saveBusinessTeacherInfo(BusinessTeacher businessTeacher);

	public BusinessTeacher getBusinessTeacher(int projectId);
	
	@Transactional
	public void updateApplicationInfo(String studentId,
			String[] projectMemberId, String[] projectMemberWork,
			Project project, BusinessTeacher businessTeacher, Cost cost,
			Student student);

	@Transactional
	public void saveBusinessApplication(String[] projectMemberId,
			String[] projectMemberWork, Project project,
			BusinessTeacher businessTeacher, Cost cost, Student student);
	
	@Transactional
	public void saveInnovationApplication(String[] projectMemberId,
			String[] projectMemberWork, Project project, Cost cost,
			Student student);

	public void deleteApplication(String studentId,int projectId);

	public void submitApplication(int projectId);
}
