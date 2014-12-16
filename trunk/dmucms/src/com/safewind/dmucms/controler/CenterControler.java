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
import com.safewind.dmucms.model.CenterReview;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.ProjectInfoForCenter;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;
import com.safewind.dmucms.service.IAppalicationService;
import com.safewind.dmucms.service.ICenterService;
import com.safewind.dmucms.util.UserAccoutUtil;

@Controller
public class CenterControler {
    
    
    private static final Logger logger = LoggerFactory.getLogger(CenterControler.class);
    
    @Autowired
    private ICenterService  CenterServiceImpl ;
    @Autowired
    private IAppalicationService AppalicationServiceImpl;
    
    @RequestMapping(value = "/center/{adminId}/viewProjectList", method = RequestMethod.GET)
    public String getAllProject(@PathVariable String adminId, @RequestParam(value = "currentPage") Integer currentPage, Model model)
    {
        int projectCount = CenterServiceImpl.getProjectCount();
        Pager page = new Pager(projectCount, currentPage);
        List<ProjectInfoForCenter> projectList = CenterServiceImpl.getAllProjectList(page.getStartRow(),page.getEndRow());
        model.addAttribute("projectList", projectList);
        model.addAttribute("page", page);
        return "college/project_list";
    }
    
    @RequestMapping(value = "/center/{adminId}/view/{shamStudentId}", method = RequestMethod.POST)
    public String viewStudentApplication(@PathVariable String adminId, @PathVariable String shamStudentId,
            @RequestParam(value = "studentId") String studentId, @RequestParam(value = "projectId") Integer projectId, Model model) {

        adminId = UserAccoutUtil.getUserLoginId();
        logger.debug("管理员教工号 ： " + adminId + "  --学生学号 ： " + studentId);
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
    
    
    @RequestMapping(value = "/center/{adminId}/review/{shamProjectId}", method = RequestMethod.POST)
    public String saveCollegeResult(
            @PathVariable String adminId, 
            @PathVariable String shamProjectId, 
            @RequestParam(value="currentPage") Integer currentPage , 
            CenterReview  centerReview ,
            Model model) {
        adminId = UserAccoutUtil.getUserLoginId();
        CenterServiceImpl.saveProjectCenterReview(centerReview);
        return "redirect:/college/" + adminId + "/viewProjectList?currentPage=" + currentPage;
    }
    
    
}
