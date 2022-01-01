package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.StudentReport;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.StudentReportMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.UserMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl.StudentReportServiceImpl;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@RestController
@CrossOrigin
//@RequestMapping(value = "/InternshipPlatform_1/student-report",produces = "application/x-www-form-urlencoded;charset=UTF-8")
@RequestMapping(value = "/InternshipPlatform_1/student-report",produces = "application/json;charset=UTF-8")
public class StudentReportController {
    @Autowired
    StudentReportMapper studentReportMapper;
    @Autowired
    StudentReportServiceImpl studentReportService;
    @Autowired
    UserMapper userMapper;
//    @GetMapping(value = "/getStudentReport", consumes = "application/x-www-form-urlencoded")
    @GetMapping(value = "/getStudentReport")
        public StudentReport getStudentReport(){

        User user = UserHolder.getUser();//当前操作用户（学生）的信息：仅含用户ID

        User studentUser = userMapper.selectById(user.getUserId());//根据当前用户ID找到完整的用户信息


        if(studentUser.getRole() != 0) //0-学生 1-教师 2-企业 3-管理员
        {
            return new StudentReport(); //返回一个空的数据类
        }

        StudentReport studentReport = studentReportService.selectByUserId(studentUser.getUserId());// 返回当前学生用户的报表信息

        studentReport.setStudentName(studentUser.getUserName());//获取当前学生用户的名字

        return studentReport;
    }
}
