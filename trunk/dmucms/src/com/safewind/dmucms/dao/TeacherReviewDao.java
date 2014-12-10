package com.safewind.dmucms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.Mapper;

import com.safewind.dmucms.domain.Teacher;
import com.safewind.dmucms.model.ProjectBasicInfo;
import com.safewind.dmucms.model.TeacherReview;

@Mapper
public interface TeacherReviewDao {

    void saveTeacherBasicInfo(Teacher teacher);

    List<ProjectBasicInfo> queryProjectListByTeacherId(@Param("teacherId") String teacherId);

    void updateReviewStudentProject(TeacherReview teacherReview);
    
}
