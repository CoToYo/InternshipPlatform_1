package com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Attendance;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.AttendanceRecord;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.AttendanceMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IAttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.DayOfWeek;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements IAttendanceService {

    @Autowired
    private AttendanceMapper attendanceMapper;


    public List<AttendanceRecord> getAttendance(int code, LocalDateTime present_time) {

        List<AttendanceRecord> attendance_record = new ArrayList<>();

        if(code == 0)//查询当天考勤记录
        {

//            QueryWrapper<Attendance> queryWrapper = new QueryWrapper<Attendance>();
//            queryWrapper.gt("attendance_time", present_time); //大于昨天（即今天的打卡记录）
//
//            attendance_record = attendanceMapper.selectList(queryWrapper);
            ;
            attendance_record = attendanceMapper.queryAttendance_0(present_time);

        }
        else if(code == 1)//查询本周考勤记录
        {

            DayOfWeek dayOfWeek = present_time.getDayOfWeek();//获取present_time在本周是星期几

            //dayOfWeek.getValue() : 星期几转换成数值形式

            LocalDateTime weekBegin = present_time.minusDays(dayOfWeek.getValue()-1); //本周第一天的日期
            weekBegin = weekBegin.minusHours(weekBegin.getHour());//小时置零
            weekBegin = weekBegin.minusMinutes(weekBegin.getMinute());//分钟置零
            weekBegin = weekBegin.minusSeconds(weekBegin.getSecond());//秒数置零
//            LocalDateTime weekEnd = weekBegin.plusDays(7); //本周最后一天的日期

            System.out.println("weekBegin");
            System.out.println(weekBegin);

            attendance_record = attendanceMapper.queryAttendance_1(weekBegin, present_time);


        }
        else if(code == 2)//查询本月考勤记录
        {
            int dayOfMonth = present_time.getDayOfMonth();

            LocalDateTime monthBegin = present_time.minusDays(dayOfMonth-1);
            monthBegin = monthBegin.minusDays(monthBegin.getDayOfMonth());//天数置零
            monthBegin = monthBegin.minusHours(monthBegin.getHour());//小时置零
            monthBegin = monthBegin.minusMinutes(monthBegin.getMinute());//分钟置零
            monthBegin =  monthBegin.minusSeconds(monthBegin.getSecond());//秒数置零

            System.out.println("monthBegin");
            System.out.println(monthBegin);

            attendance_record = attendanceMapper.queryAttendance_2(monthBegin, present_time);
        }
        return attendance_record;
    }

}
