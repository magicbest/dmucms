package com.safewind.dmucms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safewind.dmucms.dao.TeacherReviewDao;
import com.safewind.dmucms.domain.Teacher;
import com.safewind.dmucms.model.ProjectBasicInfo;
import com.safewind.dmucms.model.TeacherReview;
import com.safewind.dmucms.service.ITeacherReviewService;

@Service
public class TeacherReviewServiceImpl implements ITeacherReviewService {

    @Autowired
    private TeacherReviewDao teacherReviewDao;

    @Override
    public void saveTeacherBasicInfo(Teacher teacher) {
        teacherReviewDao.saveTeacherBasicInfo(teacher);
    }

    @Override
    public List<ProjectBasicInfo> getProjectListByTeacherId(String teacherId) {
        return teacherReviewDao.queryProjectListByTeacherId(teacherId);
    }

    @Override
    public void reviewStudentProject(TeacherReview teacherReview) {
        teacherReviewDao.updateReviewStudentProject(teacherReview);
    }

    @Override
    public int getIsProjectTeacher(String userId) {
        return teacherReviewDao.queryIsProjectTeacher(userId);
    }

}
