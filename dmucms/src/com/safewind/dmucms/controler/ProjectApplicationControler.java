package com.safewind.dmucms.controler;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.safewind.dmucms.model.Appalication;
import com.safewind.dmucms.model.BusinessTeacher;
import com.safewind.dmucms.model.Cost;
import com.safewind.dmucms.model.Project;
import com.safewind.dmucms.model.Student;
import com.safewind.dmucms.model.TeamMember;
import com.safewind.dmucms.service.IAppalicationService;
import com.safewind.dmucms.util.UserAccoutUtil;


@Controller
public class ProjectApplicationControler {
	
	@Autowired
	private IAppalicationService AppalicationServiceImpl ;
	
	@RequestMapping(value = "/innovationApplication", method = RequestMethod.GET)
	public String loadInnovationPage(Model model) {
		// 获取当前登录用户的静态方法
		String studentId = UserAccoutUtil.getUserLoginId() ;
		int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
		if(inputFlag == 0)
		{
			return "student/input_innovation";
		}
		else
		{
			return "student/already_input";
		}
	}
	
	
	@RequestMapping(value = "/businessAppalication", method = RequestMethod.GET)
	public String loadBusinessPage(Model model) {
		// 获取当前登录用户的静态方法
		String studentId = UserAccoutUtil.getUserLoginId() ;
		int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
		if(inputFlag == 0)
		{
			return "student/input_business";
		}
		else
		{
			return "student/already_input";
		}
	}
	
	
	@RequestMapping(value = "/innovationApplication", method = RequestMethod.POST)
	public String saveApplication(
			@RequestParam(value="projectMemberId") String[] projectMemberId ,@RequestParam(value="projectMemberWork")String[] projectMemberWork,Project project , Cost cost , Student student ,Model model) {
		project.setProjectMasterId(UserAccoutUtil.getUserLoginId());
		AppalicationServiceImpl.saveStudentInfo(student);
		int temp = AppalicationServiceImpl.saveProjectInfo(project);
		int projectId = AppalicationServiceImpl.queryProjectId(UserAccoutUtil.getUserLoginId());
		AppalicationServiceImpl.saveTeamInfo(projectMemberId,projectId,projectMemberWork);
		cost.setProjectId(projectId);
		AppalicationServiceImpl.saveCostInfo(cost);
		
		return "student/save_success";
	}
	
	
	@RequestMapping(value = "/businessAppalication", method = RequestMethod.POST)
	public String saveBusinessApplication(
			@RequestParam(value="projectMemberId") String[] projectMemberId ,@RequestParam(value="projectMemberWork")String[] projectMemberWork,Project project , BusinessTeacher businessTeacher , Cost cost , Student student ,Model model) {
		project.setProjectMasterId(UserAccoutUtil.getUserLoginId());
		AppalicationServiceImpl.saveStudentInfo(student);
		int temp = AppalicationServiceImpl.saveProjectInfo(project);
		int projectId = AppalicationServiceImpl.queryProjectId(UserAccoutUtil.getUserLoginId());
		businessTeacher.setProjectId(projectId);
		AppalicationServiceImpl.saveBusinessTeacherInfo(businessTeacher);
		AppalicationServiceImpl.saveTeamInfo(projectMemberId,projectId,projectMemberWork);
		cost.setProjectId(projectId);
		AppalicationServiceImpl.saveCostInfo(cost);
		
		return "student/save_success";
	}
	
	
	@RequestMapping(value = "/editApplication", method = RequestMethod.GET)
	public String editApplicationPage(Model model) {
		return "student/edit_appalication";
	}
	
	
	@RequestMapping(value = "/updateApplication", method = RequestMethod.POST)
	public String updateApplicationPage(Appalication appalication  , Model model) {
		int updateResult = AppalicationServiceImpl.updateAppalication(appalication);
		return "student/appalication_index";
	}
	
	
	@RequestMapping(value = "/viewAppalication", method = RequestMethod.GET)
	public String viewApplicationPage(Model model) {
		String studentId =  UserAccoutUtil.getUserLoginId() ;
		
		int inputFlag = AppalicationServiceImpl.getStudentInputFlag(studentId);
		
		if(inputFlag == 0)
		{
			return "student/no_appalication";
		}else{
			int projectId = AppalicationServiceImpl.queryProjectId(studentId);
			Student student = AppalicationServiceImpl.getStudentTotalInfo(studentId);
			Project project = AppalicationServiceImpl.getProjectInfo(projectId);
			
			if("CY".equals(project.getProjectType()))
			{
				Cost cost  = AppalicationServiceImpl.getCostInfo(projectId);
				BusinessTeacher businessTeacher = AppalicationServiceImpl.getBusinessTeacher(projectId);
				List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);
				model.addAttribute("memberList", memberList);
				model.addAttribute("student", student);
				model.addAttribute("project", project);
				model.addAttribute("cost", cost);
				model.addAttribute("businessTeacher", businessTeacher);
				return "student/view_appalication";
			}
			else {
				Cost cost  = AppalicationServiceImpl.getCostInfo(projectId);
				List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);
				model.addAttribute("memberList", memberList);
				model.addAttribute("student", student);
				model.addAttribute("project", project);
				model.addAttribute("cost", cost);
				return "student/view_appalication";
			}
		}
	}
	
}
