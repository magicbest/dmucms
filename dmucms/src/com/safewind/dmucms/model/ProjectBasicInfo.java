package com.safewind.dmucms.model;

public class ProjectBasicInfo {
	private Integer projectId ;
    private String projectName ;
    private String projectMannagerName ;
    private String projectMannagerId;
    private String projectMannagerPhone ;
    private String projectRank;
    private String projectCost;
    private String projectStatus;
    
   
    
    public String getProjectMannagerId()
	{
		return projectMannagerId;
	}
	public void setProjectMannagerId(String projectMannagerId)
	{
		this.projectMannagerId = projectMannagerId;
	}
	public Integer getProjectId()
	{
		return projectId;
	}
	public void setProjectId(Integer projectId)
	{
		this.projectId = projectId;
	}
	public String getProjectMannagerPhone()
	{
		return projectMannagerPhone;
	}
	public void setProjectMannagerPhone(String projectMannagerPhone)
	{
		this.projectMannagerPhone = projectMannagerPhone;
	}
	public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    public String getProjectMannagerName() {
        return projectMannagerName;
    }
    public void setProjectMannagerName(String projectMannagerName) {
        this.projectMannagerName = projectMannagerName;
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
    public String getProjectStatus() {
        return projectStatus;
    }
    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }
    
}
