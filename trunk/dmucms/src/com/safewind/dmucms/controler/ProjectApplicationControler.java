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
	
	private static final Logger logger = LoggerFactory.getLogger(ProjectApplicationControler.class);
	
	@Autowired
	private IAppalicationService AppalicationServiceImpl ;
	
	@RequestMapping(value = "/innovationApplication", method = RequestMethod.GET)
	public String loadInnovationPage(Model model) {
		// ��ȡ��ǰ��¼�û��ľ�̬����
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
	
	
	@RequestMapping(value = "/businessApplication", method = RequestMethod.GET)
	public String loadBusinessPage(Model model) {
		// ��ȡ��ǰ��¼�û��ľ�̬����
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
			@RequestParam(value="projectMemberId") String[] projectMemberId ,
			@RequestParam(value="projectMemberWork")String[] projectMemberWork,
			Project project , 
			Cost cost , 
			Student student ,Model model) {
		AppalicationServiceImpl.saveInnovationApplication(projectMemberId,projectMemberWork,project,cost,student);		
		return "student/save_success";
	}
	
	
	@RequestMapping(value = "/businessApplication", method = RequestMethod.POST)
	public String saveBusinessApplication(
			@RequestParam(value="projectMemberId") String[] projectMemberId ,@RequestParam(value="projectMemberWork")String[] projectMemberWork,Project project , BusinessTeacher businessTeacher , Cost cost , Student student ,Model model) {
		
		AppalicationServiceImpl.saveBusinessApplication(projectMemberId,projectMemberWork,project,businessTeacher,cost,student);
		return "student/save_success";
	}
	
	
	@RequestMapping(value = "/appalication/{studentId}/edit", method = RequestMethod.GET)
	public String editApplicationPage(@PathVariable String studentId,Model model) {
		
		logger.info("--------  �����޸�ҳ��  -------");
		
		studentId = UserAccoutUtil.getUserLoginId();
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
			return "student/edit_business";
		}
		else {
			Cost cost  = AppalicationServiceImpl.getCostInfo(projectId);
			List<TeamMember> memberList = AppalicationServiceImpl.getTeamMemberInfo(projectId);
			
			logger.info("�Ŷ����� �� " + memberList.size());
			
			model.addAttribute("memberList", memberList);
			model.addAttribute("student", student);
			model.addAttribute("project", project);
			model.addAttribute("cost", cost);
			return "student/edit_innovation";
		}
	}
	
	
	@RequestMapping(value = "/appalication/{studentId}/edit", method = RequestMethod.POST)
	public String updateApplicationPage(
			@PathVariable String studentId,
			@RequestParam(value="projectMemberId") String[] projectMemberId ,
			@RequestParam(value="projectMemberWork")String[] projectMemberWork,
			Project project ,
			BusinessTeacher businessTeacher ,
			Cost cost , 
			Student student ) {
		studentId = UserAccoutUtil.getUserLoginId();
		logger.info("��ǰ�û�Id �� " + studentId);
	    AppalicationServiceImpl.updateApplicationInfo(studentId,projectMemberId,projectMemberWork,project,businessTeacher,cost,student);
		return "student/update_success";
	}
	
	
	@RequestMapping(value = "/viewApplication", method = RequestMethod.GET)
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