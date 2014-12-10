package com.safewind.dmucms.domain;

import java.io.Serializable;

public class Teacher implements Serializable {
    
    private static final long serialVersionUID = -6025137579220225273L;
    
    private String  teacherId;
    private String  teacherPhone;
    private String  teacherPosition;
    private String  teacherTitle;
    private String  teacherDegree;
    private String  teacherResearch;
    public String getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
    public String getTeacherPhone() {
        return teacherPhone;
    }
    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }
    public String getTeacherPosition() {
        return teacherPosition;
    }
    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition;
    }
    public String getTeacherTitle() {
        return teacherTitle;
    }
    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }
    public String getTeacherDegree() {
        return teacherDegree;
    }
    public void setTeacherDegree(String teacherDegree) {
        this.teacherDegree = teacherDegree;
    }
    public String getTeacherResearch() {
        return teacherResearch;
    }
    public void setTeacherResearch(String teacherResearch) {
        this.teacherResearch = teacherResearch;
    }
}
