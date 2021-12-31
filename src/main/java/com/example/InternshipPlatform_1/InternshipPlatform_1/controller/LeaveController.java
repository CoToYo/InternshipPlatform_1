package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Leave;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.LeaveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

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

    @PostMapping(value = "/confirm", consumes = "application/json")
    public String uploadLeaveRecord(@RequestBody Leave leave){
        LocalDateTime present_time = LocalDateTime.now();
        leave.setAskTime(present_time);//后台生成请假申请的请求时间

        leaveMapper.insert(leave);//将请假信息写入数据库

        return "The LeaveRecord has been uploaded successfully!";
    }

}
