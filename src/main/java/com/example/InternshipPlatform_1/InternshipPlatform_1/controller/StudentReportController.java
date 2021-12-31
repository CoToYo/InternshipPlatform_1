package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.StudentReport;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.StudentReportMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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
@RequestMapping(value = "/InternshipPlatform_1/student-report",produces = "application/x-www-form-urlencoded;charset=UTF-8")
public class StudentReportController {
    @Autowired
    StudentReportMapper studentReportMapper;
    @GetMapping(value = "/getStudentReport", consumes = "application/x-www-form-urlencoded")
    public StudentReport getStudentReport(@RequestParam("userId") Integer userId, @RequestParam("role") Integer role){
        System.out.println(userId);
        User user = UserHolder.getUser();

        System.out.println(user);
        if(role != 0) //0-学生 1-教师 2-企业 3-管理员
        {
            return new StudentReport(); //返回一个空的数据类
        }
        StudentReport studentReport = studentReportMapper.selectById(userId);
        return studentReport;
    }
}
