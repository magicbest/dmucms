package com.safewind.dmucms.model;

public class TeacherReview {
    private Integer projectId;
    private Integer projectResult;
    private String  teacherComment;
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
    public String getTeacherComment() {
        return teacherComment;
    }
    public void setTeacherComment(String teacherComment) {
        this.teacherComment = teacherComment;
    }
}
