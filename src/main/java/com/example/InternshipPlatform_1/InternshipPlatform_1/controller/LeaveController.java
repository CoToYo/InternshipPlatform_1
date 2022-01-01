package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Leave;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.LeaveMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping(value = "/leaveHistory")
    public List<Leave> leaveHistory() {
        User applicant = UserHolder.getUser();
        System.out.print(applicant);
        System.out.println("Showing leave history:\n");

//        leaveHistory = leaveMapper.getLeaveHistory(applicant.getUserId());
        QueryWrapper<Leave> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("applicant_id",applicant.getUserId());
        List<Leave> leaveHistory = leaveMapper.selectList(queryWrapper);
        System.out.println(leaveHistory);
        return leaveHistory;
    }

}
