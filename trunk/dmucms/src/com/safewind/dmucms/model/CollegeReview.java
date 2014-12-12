package com.safewind.dmucms.model;

public class CollegeReview {
    private Integer projectId;
    private Integer projectResult;
    private String  collegeComment;
    public Integer getProjectId() {
        return projectId;
    }
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    public Integer getProjectResult() {
        return projectResult;
    }
    public void setProjectResult(Integer projectResult) {
        this.projectResult = projectResult;
    }
    public String getCollegeComment() {
        return collegeComment;
    }
    public void setCollegeComment(String collegeComment) {
        this.collegeComment = collegeComment;
    }
    
}
