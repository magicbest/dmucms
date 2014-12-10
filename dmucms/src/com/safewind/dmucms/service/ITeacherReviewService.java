package com.safewind.dmucms.service;

import java.util.List;

import com.safewind.dmucms.domain.Teacher;
import com.safewind.dmucms.model.ProjectBasicInfo;
import com.safewind.dmucms.model.TeacherReview;

public interface ITeacherReviewService {

    void saveTeacherBasicInfo(Teacher teacher);

    List<ProjectBasicInfo> getProjectListByTeacherId(String teacherId);

    void reviewStudentProject(TeacherReview teacherReview);

}
