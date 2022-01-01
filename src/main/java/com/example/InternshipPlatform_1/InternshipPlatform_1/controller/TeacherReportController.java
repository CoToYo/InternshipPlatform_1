package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.StudentReport;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.TeacherReport;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.TeacherReportMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.UserMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl.TeacherReportServiceImpl;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/InternshipPlatform_1/teacher-report")
public class TeacherReportController {

    @Autowired
    TeacherReportMapper teacherReportMapper;
    @Autowired
    TeacherReportServiceImpl teacherReportService;
    @Autowired
    UserMapper userMapper;

    @PostMapping("getTeacherReport")
    public TeacherReport getTeacherReport(){

        User user = UserHolder.getUser();//获取当前操作用户（教师）的用户信息：仅包含用户ID
        User teacherUser = userMapper.selectById(user.getUserId());//获取当前教师用户完整的用户信息

        if(teacherUser.getRole() != 1) //0-学生 1-教师 2-企业 3-管理员
        {
            return new TeacherReport(); //返回一个空的数据类
        }

        TeacherReport teacherReport = teacherReportMapper.selectById(teacherUser.getUserId());//获取当前教师用户的报表
        teacherReport.setTeacherName(teacherUser.getUserName());//获取当前教师用户的姓名

        return teacherReport;

    }

}
