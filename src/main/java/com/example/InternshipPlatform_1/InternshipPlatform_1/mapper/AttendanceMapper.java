package com.example.InternshipPlatform_1.InternshipPlatform_1.mapper;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Attendance;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.AttendanceRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Mapper
public interface AttendanceMapper extends BaseMapper<Attendance> {

    List<AttendanceRecord> queryAttendance_0(LocalDateTime present_time); //查询当日考勤记录的sql查询方法
    List<AttendanceRecord> queryAttendance_1(@Param("weekBegin") LocalDateTime weekBegin, @Param("present_time") LocalDateTime present_time); //查询本周考勤记录的sql查询方法 //由于weekBegin为局部变量，需要用@Param注释声明之后 xml中才能将它找到!
    List<AttendanceRecord> queryAttendance_2(@Param("monthBegin") LocalDateTime monthBegin, @Param("present_time") LocalDateTime present_time); //查询本月考勤记录的sql查询方法

}

