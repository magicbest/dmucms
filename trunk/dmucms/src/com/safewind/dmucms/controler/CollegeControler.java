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

import com.safewind.dmucms.domain.Pager;
import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.CollegeProjectSearchParm;
import com.safewind.dmucms.model.CollegeReview;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.ProjectInfoForCollege;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;
import com.safewind.dmucms.service.IAppalicationService;
import com.safewind.dmucms.service.ICollegeService;
import com.safewind.dmucms.util.UserAccoutUtil;

@Controller
public class CollegeControler {
    private static final Logger logger = LoggerFactory.getLogger(CollegeControler.class);

    @Autowired
    private ICollegeService CollegeServiceImpl;
    @Autowired
    private IAppalicationService AppalicationServiceImpl;

    @RequestMapping(value = "/college/{shamDeanId}/viewProjectList", method = RequestMethod.GET)
    public String getProjectList(@PathVariable String shamDeanId, @RequestParam(value = "currentPage") Integer currentPage, Model model) {
    	 String userId = UserAccoutUtil.getUserLoginId();
    	String collegeName = CollegeServiceImpl.getMasterCollegeName(userId);
        int projectCount = CollegeServiceImpl.getProjectCount(collegeName);
        Pager page = new Pager(projectCount, currentPage);
        CollegeProjectSearchParm searchParm = new CollegeProjectSearchParm();
        searchParm.setCollegeName(collegeName);
        searchParm.setStartRow(page.getStartRow());
        searchParm.setEndRow(page.getEndRow());
        List<ProjectInfoForCollege> projectList = CollegeServiceImpl.getProjectListByCollege(searchParm);
        model.addAttribute("projectList", projectList);
        model.addAttribute("page", page);
        return "college/project_list";
    }

    @RequestMapping(value = "/college/{deanId}/view/{shamStudentId}", method = RequestMethod.POST)
    public String viewStudentApplication(@PathVariable String deanId, @PathVariable String shamStudentId,
            @RequestParam(value = "studentId") String studentId, @RequestParam(value = "projectId") Integer projectId, Model model) {

        deanId = UserAccoutUtil.getUserLoginId();
        logger.debug("老师教工号 ： " + deanId + "  --学生学号 ： " + studentId);
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
            return "college/view_appalication";
        } else {
            Cost cost = AppalicationServiceImpl.getCostInfo(projectId);
            List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);
            model.addAttribute("memberList", memberList);
            model.addAttribute("student", student);
            model.addAttribute("project", project);
            model.addAttribute("cost", cost);
            return "college/view_appalication";
        }
    }

    @RequestMapping(value = "/college/{deanId}/review/{shamProjectId}", method = RequestMethod.POST)
    public String saveCollegeResult(
            @PathVariable String deanId, 
            @PathVariable String shamProjectId, 
            @RequestParam(value="currentPage") Integer currentPage , 
            CollegeReview collegeReview,
            Model model) {
        deanId = UserAccoutUtil.getUserLoginId();
        CollegeServiceImpl.saveProjectCollegeStatus(collegeReview);
        return "redirect:/college/" + deanId + "/viewProjectList?currentPage=" + currentPage;
    }

}
