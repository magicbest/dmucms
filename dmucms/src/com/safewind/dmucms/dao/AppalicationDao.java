package com.safewind.dmucms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.Mapper;

import com.safewind.dmucms.model.Appalication;
import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;

@Mapper
public interface AppalicationDao
{
	Student getStudentBasicInfo(@Param("studentId")String studentId);

	void saveProjectInfo(Project project);

	int getStudentInputFlag(@Param("studentId")String studentId);


	void saveTeamInfo(@Param("projectId")int projectId, @Param("memberId")String memberId , @Param("projectMemberWork")String projectMemberWork);

	void saveCostInfo(Cost cost);

	int queryProjectIdByUserId(@Param("studentId")String userLoginId);

	void saveStudentInfo(Student student);

	Student getStudentTotalInfo(@Param("studentId")String studentId);

	Project getProjectInfo(@Param("projectId")int projectId);

	Cost getCostInfo(@Param("projectId") int projectId);

	List<TeamMember> getTeamMemberInfo(@Param("projectId")int projectId);

	void saveBusinessTeacherInfo(BusinessTeacher businessTeacher);

	BusinessTeacher getBusinessTeacher(@Param("projectId")int projectId);

	void updateProjectInfo(Project project);

	void updateCostInfo(Cost cost);

	void updateStudentInfo(Student student);

	void deleteOldTeamInfo(@Param("projectId")int projectId);

	void updateBusinessTeacherInfo(BusinessTeacher businessTeacher);

	void deleteApplicationByProId(@Param("projectId")int projectId);

	
}
