package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Leave;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.LeaveMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.UserMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/InternshipPlatform_1/leave")
public class LeaveController {

    @Autowired
    LeaveMapper leaveMapper;
    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/confirm", consumes = "application/json")
    public String uploadLeaveRecord(@RequestBody Leave leave){

        System.out.println("LeaveTime: "+leave.getLeaveTime());

        //数据格式转化: LocalDateTime->Date
//        ZoneId zoneId = ZoneId.systemDefault();
//        ZonedDateTime zdt = LocalDateTime.now().atZone(zoneId);
//        Date present_time = Date.from(zdt.toInstant());

        LocalDateTime present_time = LocalDateTime.now();
        leave.setAskTime(present_time);//后台生成请假申请的请求时间


        User applicantUser = UserHolder.getUser();//当前操作者(请假申请者)的信息
        leave.setApplicantId(applicantUser.getUserId());//记录请假申请者的ID
        leave.setApplicantName(userMapper.selectById(applicantUser.getUserId()).getUserName());//记录请假申请者的姓名
        System.out.println(leave);

        leaveMapper.insert(leave);//将请假信息写入数据库

        return "The LeaveRecord has been uploaded successfully!";
    }

}
