package com.safewind.dmucms.controler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.safewind.dmucms.annotation.StudentPermissionCheck;
import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.ProjectInfoForStudent;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;
import com.safewind.dmucms.service.IAppalicationService;
import com.safewind.dmucms.util.UserAccoutUtil;

@Controller
public class ProjectApplicationControler {

    private static final Logger logger = LoggerFactory.getLogger(ProjectApplicationControler.class);

    @Autowired
    private IAppalicationService AppalicationServiceImpl;

    @RequestMapping(value = "/innovationApplication", method = RequestMethod.GET)
    public String loadInnovationPage(Model model) {
        String studentId = UserAccoutUtil.getUserLoginId();
        int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
        if (inputFlag == 0) {
            return "student/input_innovation";
        } else {
            return "student/already_input";
        }
    }

    @RequestMapping(value = "/businessApplication", method = RequestMethod.GET)
    public String loadBusinessPage(Model model) {
        // 获取当前登录用户
        String studentId = UserAccoutUtil.getUserLoginId();
        int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
        if (inputFlag == 0) {
            return "student/input_business";
        } else {
            return "student/already_input";
        }
    }

    @RequestMapping(value = "/innovationApplication", method = RequestMethod.POST)
    public String saveApplication(@RequestParam(value = "projectMemberId", required = false) String[] projectMemberId,
            @RequestParam(value = "projectMemberWork", required = false) String[] projectMemberWork, Project project, Cost cost,
            Student student, Model model, HttpSession session) {
    	logger.info(UserAccoutUtil.getUserLoginId() + " 保存创新申请书开始.....");
        AppalicationServiceImpl.saveInnovationApplication(projectMemberId, projectMemberWork, project, cost, student);
        logger.info(UserAccoutUtil.getUserLoginId() + " 保存创新申请书结束.....");
        session.setAttribute("isProjectMannager", true);
        return "student/save_success";
    }

    @RequestMapping(value = "/businessApplication", method = RequestMethod.POST)
    public String saveBusinessApplication(@RequestParam(value = "projectMemberId", required = false) String[] projectMemberId,
            @RequestParam(value = "projectMemberWork", required = false) String[] projectMemberWork, Project project,
            BusinessTeacher businessTeacher, Cost cost, Student student, Model model, HttpSession session) {
    	
    	logger.info(UserAccoutUtil.getUserLoginId() + " 保存创业申请书开始.....");
        AppalicationServiceImpl.saveBusinessApplication(projectMemberId, projectMemberWork, project, businessTeacher, cost, student);
        logger.info(UserAccoutUtil.getUserLoginId() + " 保存创业申请书结束.....");
        session.setAttribute("isProjectMannager", true);
        return "student/save_success";
    }

    @StudentPermissionCheck(isProjectMannagerCheck = true, permissionLevel = 1)
    @RequestMapping(value = "/appalication/{studentId}/edit", method = RequestMethod.GET)
    public String editApplicationPage(@PathVariable String studentId, Model model) {

        logger.info("-----" +  studentId  +  "---  进入修改页面 -------");

        int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
        if (inputFlag == 0) {
            return "student/no_appalication";
        } else {

            studentId = UserAccoutUtil.getUserLoginId();
            int projectId = AppalicationServiceImpl.queryProjectId(studentId);
            int projectStatus = AppalicationServiceImpl.queryProjectStatus(projectId);
            if (projectStatus >= 2) {
                return "redirect:/prompt?promptType=editRefuse";
            }
            Student student = AppalicationServiceImpl.getStudentTotalInfo(studentId);
            Project project = AppalicationServiceImpl.getProjectInfo(projectId);

            if ("CY".equals(project.getProjectType())) {
                Cost cost = AppalicationServiceImpl.getCostInfo(projectId);
                BusinessTeacher businessTeacher = AppalicationServiceImpl.getBusinessTeacher(projectId);
                List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);

                model.addAttribute("memberList", memberList);
                model.addAttribute("student", student);
                model.addAttribute("project", project);
                model.addAttribute("cost", cost);
                model.addAttribute("businessTeacher", businessTeacher);
                return "student/edit_business";
            } else {
                Cost cost = AppalicationServiceImpl.getCostInfo(projectId);
                List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);
                logger.info("成员数量 ：" + memberList.size());

                model.addAttribute("memberList", memberList);
                model.addAttribute("student", student);
                model.addAttribute("project", project);
                model.addAttribute("cost", cost);
                return "student/edit_innovation";
            }
        }
    }

    @StudentPermissionCheck(isProjectMannagerCheck = true, permissionLevel = 1)
    @RequestMapping(value = "/appalication/{studentId}/edit", method = RequestMethod.POST)
    public String updateApplicationPage(@PathVariable String studentId, @RequestParam(value = "projectMemberId") String[] projectMemberId,
            @RequestParam(value = "projectMemberWork") String[] projectMemberWork, Project project, BusinessTeacher businessTeacher,
            Cost cost, Student student) {
        studentId = UserAccoutUtil.getUserLoginId();
        logger.info("-----" +  studentId  +  "---保存修改 开始-------");
        AppalicationServiceImpl.updateApplicationInfo(studentId, projectMemberId, projectMemberWork, project, businessTeacher, cost,
                student);
        logger.info("-----" +  studentId  +  "---保存修改结束 -------");
        return "student/update_success";
    }

    @StudentPermissionCheck(isProjectMannagerCheck = true, permissionLevel = 1)
    @RequestMapping(value = "/appalication/{studentId}/view", method = RequestMethod.GET)
    public String viewApplicationPage(@PathVariable String studentId, Model model) {

        studentId = UserAccoutUtil.getUserLoginId();

        int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);

        if (inputFlag == 0) {
            return "student/no_appalication";
        } else {
            int projectId = AppalicationServiceImpl.queryProjectId(studentId);
            Student student = AppalicationServiceImpl.getStudentTotalInfo(studentId);
            Project project = AppalicationServiceImpl.getProjectInfo(projectId);

            if ("CY".equals(project.getProjectType())) {
                Cost cost = AppalicationServiceImpl.getCostInfo(projectId);
                BusinessTeacher businessTeacher = AppalicationServiceImpl.getBusinessTeacher(projectId);
                List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);
                model.addAttribute("memberList", memberList);
                model.addAttribute("student", student);
                model.addAttribute("project", project);
                model.addAttribute("cost", cost);
                model.addAttribute("businessTeacher", businessTeacher);
                return "student/view_appalication";
            } else {
                Cost cost = AppalicationServiceImpl.getCostInfo(projectId);
                List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);
                model.addAttribute("memberList", memberList);
                model.addAttribute("student", student);
                model.addAttribute("project", project);
                model.addAttribute("cost", cost);
                return "student/view_appalication";
            }
        }
    }

    @StudentPermissionCheck(isProjectMannagerCheck = true, permissionLevel = 1)
    @RequestMapping(value = "/appalication/{studentId}/delete", method = RequestMethod.GET)
    public String deleteApplication(@PathVariable String studentId, Model model) {
        studentId = UserAccoutUtil.getUserLoginId();
        int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
        if (inputFlag == 0) {
            return "student/no_appalication";
        } else {
            int projectId = AppalicationServiceImpl.queryProjectId(studentId);
            int projectStatus = AppalicationServiceImpl.queryProjectStatus(projectId) ;
            if(projectStatus < 2)
            {
            	logger.info("-----" +  studentId  +  "---删除申请书开始 -------");
            	AppalicationServiceImpl.deleteApplication(studentId, projectId);
            	logger.info("-----" +  studentId  +  "---删除申请书结束 -------");
            	return "student/delete_success";
            }else {
            	
            	return "redirect:/prompt?promptType=deleteRefuse";
			}
        }

    }

    @StudentPermissionCheck(isProjectMannagerCheck = true, permissionLevel = 1)
    @RequestMapping(value = "/appalication/{studentId}/submit", method = RequestMethod.GET)
    public String submitApplication(@PathVariable String studentId, Model model) {
        studentId = UserAccoutUtil.getUserLoginId();
        int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
        if (inputFlag == 0) {
            return "student/no_appalication";
        } else {
            int projectId = AppalicationServiceImpl.queryProjectId(studentId);
            int projectStatus = AppalicationServiceImpl.queryProjectStatus(projectId) ;
            if(projectStatus == 0)
            {
            	logger.info("-----" +  studentId  +  "---提交申请书开始 -------");
                AppalicationServiceImpl.submitApplication(projectId);
                logger.info("-----" +  studentId  +  "---提交申请书结束 -------");
            }else {
                return "redirect:/prompt?promptType=submitRefuse";
            }
            return "student/submit_success";
        }
    }
    
    
    @StudentPermissionCheck(isProjectMannagerCheck = true, permissionLevel = 1)
    @RequestMapping(value = "/application/{studentId}/myApplication", method = RequestMethod.GET)
    public String viewMyApplication(@PathVariable String studentId, Model model) {
        studentId = UserAccoutUtil.getUserLoginId();
        int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
        if (inputFlag == 0) {
            return "student/no_appalication";
        } else {
            int projectId = AppalicationServiceImpl.queryProjectId(studentId);
            ProjectInfoForStudent project = AppalicationServiceImpl.getProjectInfoByProjectId(projectId);
            logger.info("-------------- "  + project.getTeacherComment() );
            model.addAttribute("project", project);
            return "student/my_application";
        }
    }

}
