package com.safewind.dmucms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.safewind.dmucms.dao.AppalicationDao;
import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.ProjectInfoForStudent;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;
import com.safewind.dmucms.service.IAppalicationService;
import com.safewind.dmucms.util.UserAccoutUtil;

@Service
public class AppalicationServiceImpl implements IAppalicationService {
    @Autowired
    private AppalicationDao appalicationDao;

    @Override
    public Student getStudentBasicInfo(String studentId) {
        Student student = appalicationDao.getStudentBasicInfo(studentId);
        return student;
    }

    @Override
    public void saveProjectInfo(Project project) {
        appalicationDao.saveProjectInfo(project);
    }

    @Override
    public int getStudentInputFlag(String studentId) {
        return appalicationDao.getStudentInputFlag(studentId);
    }

    @Override
    public void saveTeamInfo(String[] projectMemberId, int projectId, String[] projectMemberWork) {
        for (int i = 1; i < projectMemberId.length; i++) {
            appalicationDao.saveTeamInfo(projectId, projectMemberId[i], projectMemberWork[i]);
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

    @Transactional
    public void updateApplicationInfo(String studentId, String[] projectMemberId, String[] projectMemberWork, Project project,
            BusinessTeacher businessTeacher, Cost cost, Student student) {
        int projectId = this.queryProjectId(studentId);

        cost.setProjectId(projectId);
        project.setProjectId(projectId);

        if ("CY".equals(project.getProjectType())) {
            businessTeacher.setProjectId(projectId);
            appalicationDao.updateProjectInfo(project);
            appalicationDao.updateCostInfo(cost);
            appalicationDao.updateStudentInfo(student);
            appalicationDao.deleteOldTeamInfo(projectId);
            appalicationDao.updateBusinessTeacherInfo(businessTeacher);
            for (int i = 1; i < projectMemberId.length; i++) {
                appalicationDao.saveTeamInfo(projectId, projectMemberId[i], projectMemberWork[i]);
            }
        } else {
            appalicationDao.updateProjectInfo(project);

            appalicationDao.updateCostInfo(cost);

            appalicationDao.updateStudentInfo(student);

            appalicationDao.deleteOldTeamInfo(projectId);

            for (int i = 1; i < projectMemberId.length; i++) {
                appalicationDao.saveTeamInfo(projectId, projectMemberId[i], projectMemberWork[i]);
            }
        }
    }

    @Transactional
    public void saveBusinessApplication(String[] projectMemberId, String[] projectMemberWork, Project project,
            BusinessTeacher businessTeacher, Cost cost, Student student) {
        project.setProjectMasterId(UserAccoutUtil.getUserLoginId());
        saveStudentInfo(student);
        saveProjectInfo(project);
        int projectId = queryProjectId(UserAccoutUtil.getUserLoginId());
        businessTeacher.setProjectId(projectId);
        saveBusinessTeacherInfo(businessTeacher);
        saveTeamInfo(projectMemberId, projectId, projectMemberWork);
        cost.setProjectId(projectId);
        saveCostInfo(cost);
    }

    @Transactional
    public void saveInnovationApplication(String[] projectMemberId, String[] projectMemberWork, Project project, Cost cost, Student student) {
        project.setProjectMasterId(UserAccoutUtil.getUserLoginId());
        saveStudentInfo(student);
        saveProjectInfo(project);
        int projectId = queryProjectId(UserAccoutUtil.getUserLoginId());
        saveTeamInfo(projectMemberId, projectId, projectMemberWork);
        cost.setProjectId(projectId);
        saveCostInfo(cost);
    }

    @Transactional
    public void deleteApplication(String studentId, int projectId) {
        String projectType = appalicationDao.queryProjectType(projectId);
        if ("CX".equals(projectType)) {
            appalicationDao.deleteProjectInfo(projectId);
            appalicationDao.deleteCostInfo(projectId);
            appalicationDao.deleteTeamInfo(projectId);
            appalicationDao.deleteStudentInfo(studentId);
        } else {
            appalicationDao.deleteProjectInfo(projectId);
            appalicationDao.deleteCostInfo(projectId);
            appalicationDao.deleteTeamInfo(projectId);
            appalicationDao.deleteBusinessTeacherInfo(projectId);
            appalicationDao.deleteStudentInfo(studentId);
        }
    }

    @Override
    public void submitApplication(int projectId) {
        appalicationDao.updateProjectStatus(projectId);
    }

    @Override
    public int queryTeacherInputFlag(String userId) {
        int teacherInputFlag = appalicationDao.queryTeacherInputFlag(userId);
        return teacherInputFlag;
    }

	@Override
	public int queryProjectStatus(int projectId)
	{
		return appalicationDao.queryProjectStatus(projectId);
	}

	@Override
	public ProjectInfoForStudent getProjectInfoByProjectId(int projectId)
	{
		return appalicationDao.queryProjectInfoByProjectId(projectId);
	}
}
