package com.safewind.dmucms.service;

import java.util.List;

import com.safewind.dmucms.model.Appalication;
import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;

public interface IAppalicationService
{
	public Student getStudentBasicInfo(String studentId);

	public int saveProjectInfo(Project project);

	public int updateAppalication(Appalication appalication);

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


}
