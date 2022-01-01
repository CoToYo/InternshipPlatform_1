package com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.StudentReport;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.StudentReportMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IStudentReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Service
public class StudentReportServiceImpl extends ServiceImpl<StudentReportMapper, StudentReport> implements IStudentReportService {

    @Autowired
    StudentReportMapper studentReportMapper;

    public StudentReport selectByUserId(Integer studentId){

        QueryWrapper<StudentReport> wrapper = Wrappers.query();
        wrapper.likeRight("student_id", studentId);

        StudentReport studentReport = studentReportMapper.selectOne(wrapper);

        return studentReport;
    }

}
