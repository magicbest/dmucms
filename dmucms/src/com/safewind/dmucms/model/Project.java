package com.safewind.dmucms.model;

public class Project {
	private Integer projectId ;
	private String  projectRealId ;
	private String  projectType;
	private String  projectName;
	private String  projectMasterId;
	private String  projectSubject;
	private String  projectRank;
	private String  projectCost;
	private String  projectFrom;
	private String  projectFromName;
	private String  projectTeacherName;
	private String  projectTeacherId;
	private String  projectContent;
	private String  projectSpecial;
	private String  teacherComment;
	private int  projectStatus;
	
	
	
	public String getTeacherComment() {
		return teacherComment;
	}
	public void setTeacherComment(String teacherComment) {
		this.teacherComment = teacherComment;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getProjectRealId() {
		return projectRealId;
	}
	public void setProjectRealId(String projectRealId) {
		this.projectRealId = projectRealId;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectSubject() {
		return projectSubject;
	}
	public void setProjectSubject(String projectSubject) {
		this.projectSubject = projectSubject;
	}
	public String getProjectRank() {
		return projectRank;
	}
	public void setProjectRank(String projectRank) {
		this.projectRank = projectRank;
	}
	public String getProjectCost() {
		return projectCost;
	}
	public void setProjectCost(String projectCost) {
		this.projectCost = projectCost;
	}
	public String getProjectFrom() {
		return projectFrom;
	}
	public void setProjectFrom(String projectFrom) {
		this.projectFrom = projectFrom;
	}
	public String getProjectFromName() {
		return projectFromName;
	}
	public void setProjectFromName(String projectFromName) {
		this.projectFromName = projectFromName;
	}
	public String getProjectTeacherName() {
		return projectTeacherName;
	}
	public void setProjectTeacherName(String projectTeacherName) {
		this.projectTeacherName = projectTeacherName;
	}
	public String getProjectTeacherId() {
		return projectTeacherId;
	}
	public void setProjectTeacherId(String projectTeacherId) {
		this.projectTeacherId = projectTeacherId;
	}
	public String getProjectContent() {
		return projectContent;
	}
	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}
	public String getProjectSpecial() {
		return projectSpecial;
	}
	public void setProjectSpecial(String projectSpecial) {
		this.projectSpecial = projectSpecial;
	}
	public String getProjectMasterId() {
		return projectMasterId;
	}
	public void setProjectMasterId(String projectMasterId) {
		this.projectMasterId = projectMasterId;
	}
	public int getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(int projectStatus) {
		this.projectStatus = projectStatus;
	}
	
}
