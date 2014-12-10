package com.safewind.dmucms.controler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.safewind.dmucms.domain.Teacher;
import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.ProjectBasicInfo;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeacherReview;
import com.safewind.dmucms.model.TeamMember;
import com.safewind.dmucms.service.IAppalicationService;
import com.safewind.dmucms.service.ITeacherReviewService;
import com.safewind.dmucms.util.UserAccoutUtil;

@Controller
public class TeacherReviewControler {
    
    private static final Logger logger = LoggerFactory.getLogger(TeacherReviewControler.class);

    @Autowired
    private ITeacherReviewService TeacherReviewServiceImpl;
    @Autowired
    private IAppalicationService AppalicationServiceImpl;

    @RequestMapping(value = "/teacher/{teacherId}/saveBasicInfo", method = RequestMethod.POST)
    public String saveTeacherInfo(@PathVariable String teacherId ,Teacher teacher) {
        teacherId = UserAccoutUtil.getUserLoginId();
        teacher.setTeacherId(teacherId);
        TeacherReviewServiceImpl.saveTeacherBasicInfo(teacher);
        return "redirect:/";
    }
    
    @RequestMapping(value = "/teacher/{teacherId}/viewProjectList", method = RequestMethod.GET)
    public String viewStudentProjectList(@PathVariable String teacherId,Model model) {
        teacherId = UserAccoutUtil.getUserLoginId();
        List<ProjectBasicInfo> projectList = TeacherReviewServiceImpl.getProjectListByTeacherId(teacherId);
        logger.info("项目数量 ： "  +  projectList.size());
        model.addAttribute("projectList", projectList);
        return "teacher/project_list";
    }
    
    @RequestMapping(value = "/teacher/{teacherId}/view/{shamStudentId}", method = RequestMethod.POST)
    public String viewStudentProjectDetail(
            @PathVariable String teacherId,
            @PathVariable String shamStudentId,
            @RequestParam(value="projectMannagerId") String studentId,
            @RequestParam(value="projectId") Integer projectId,
            Model model) {
        teacherId = UserAccoutUtil.getUserLoginId();
        logger.debug("老师教工号 ： "  + teacherId + "  --学生学号 ： " + studentId);
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
            return "teacher/view_appalication";
        } else {
            Cost cost = AppalicationServiceImpl.getCostInfo(projectId);
            List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);
            model.addAttribute("memberList", memberList);
            model.addAttribute("student", student);
            model.addAttribute("project", project);
            model.addAttribute("cost", cost);
            return "teacher/view_appalication";
        }
    }
    
    
    @RequestMapping(value = "/teacher/{teacherId}/review/{shamProjectId}", method = RequestMethod.GET)
    public String passStudentProject(
            @PathVariable String teacherId,
            @PathVariable String shamProjectId,
            TeacherReview teacherReview,
            Model model) {
    	teacherReview.setProjectId(161);
    	teacherReview.setProjectResult(2);
    	teacherReview.setTeacherComment("项目很好");
        teacherId = UserAccoutUtil.getUserLoginId();
        TeacherReviewServiceImpl.reviewStudentProject(teacherReview);
        return "redirect:/teacher/"+ teacherId +"/viewProjectList";
    }
    
    
    
    
}
