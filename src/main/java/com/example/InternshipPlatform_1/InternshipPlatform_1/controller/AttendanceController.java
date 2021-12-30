package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Attendance;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.AttendanceRecord;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.AttendanceMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl.AttendanceServiceImpl;
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
//@CrossOrigin
@RequestMapping(value = "/InternshipPlatform_1/attendance" ,produces = "application/json;charset=UTF-8")
public class AttendanceController {

    @Autowired
    AttendanceMapper attendanceMapper;


//    考勤确认，向数据库存入新的考勤记录
    LocalDateTime attendance_time = LocalDateTime.now();

    @PostMapping (value = "/confirm", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)

    public String Attendance(@RequestBody Attendance attendance){

        attendance.setAttendanceTime(attendance_time); //后台生成考勤打卡时间

        int result;
        result = attendanceMapper.insert(attendance);

//        attendanceService.list();
//        Attendance attendance1 = attendanceService.getBaseMapper().selectById(1);

        return "The attendance record of user: "+attendance.getUserId()+" has been successfully created!";




    }

    @Autowired
    AttendanceServiceImpl attendanceService;

    @GetMapping(value = "/getAttendance")
    @ResponseStatus(HttpStatus.CREATED)
    public List<AttendanceRecord> getAttendance(int code, @DateTimeFormat(pattern = "yyyy-MM-ddHH:mm:ss") LocalDateTime present_time){

        System.out.println("present_time: "+present_time);

        //AttendanceRecord是专门为考勤记录的查询设计的实体类
        List<AttendanceRecord> attendance = this.attendanceService.getAttendance(code, present_time); //code为状态码：0-查询当日考勤记录，1-查询当周考勤记录，2-查询当月考勤记录

        return attendance;

    }
}
