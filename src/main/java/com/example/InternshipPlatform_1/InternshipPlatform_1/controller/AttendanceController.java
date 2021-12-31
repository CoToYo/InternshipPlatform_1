package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Attendance;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.AttendanceRecord;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.AttendanceMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.UserMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl.AttendanceServiceImpl;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
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
@ResponseBody
@CrossOrigin
@RequestMapping(value = "/InternshipPlatform_1/attendance")
public class AttendanceController {

    @Autowired
    AttendanceMapper attendanceMapper;
    @Autowired
    UserMapper userMapper;


    //模块：考勤打卡，向数据库存入新的考勤记录
    LocalDateTime attendance_time = LocalDateTime.now();

    @PostMapping (value = "/confirm")
    @ResponseStatus(HttpStatus.CREATED)

    public String Attendance(@RequestBody Attendance attendance){

        //当前操作的用户信息
        User user = UserHolder.getUser();

        attendance.setAttendanceId(user.getUserId());
        attendance.setAttendanceTime(attendance_time); //后台生成考勤打卡时间

        user.setRole(userMapper.selectById(UserHolder.getUser()).getRole());// 获取当前操作用户的身份

        if(user.getRole() != 0) //若当前用户不为学生，则无法进行考勤打卡操作
        {
            return "You don't have authority to do this.";
        }


        int result;
        result = attendanceMapper.insert(attendance);

        return "The attendance record of user: "+attendance.getUserId()+" has been successfully created!";


    }

    //模块：教师查看不同时间段的考勤记录
    @Autowired
    AttendanceServiceImpl attendanceService;

    @GetMapping(value = "/getAttendance")
    @ResponseStatus(HttpStatus.CREATED)
    public List<AttendanceRecord> getAttendance(int code, @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss") LocalDateTime present_time){


        //AttendanceRecord是专门为考勤记录的查询设计的实体类
        List<AttendanceRecord> attendance = this.attendanceService.getAttendance(code, present_time); //code为状态码：0-查询当日考勤记录，1-查询当周考勤记录，2-查询当月考勤记录

        return attendance;

    }
}
