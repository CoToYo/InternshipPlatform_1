package com.example.InternshipPlatform_1.InternshipPlatform_1.service;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Attendance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.AttendanceRecord;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
public interface IAttendanceService extends IService<Attendance> {
    List<AttendanceRecord> getAttendance(int code, LocalDateTime present_time);


}
