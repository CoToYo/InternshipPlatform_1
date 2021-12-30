package com.example.InternshipPlatform_1;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Announcement;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Attendance;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.AttendanceRecord;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.AnnouncementMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.AttendanceMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class InternshipPlatform1ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    public AnnouncementMapper announcementMapper;

    @Autowired
    public AttendanceMapper attendanceMapper;

    @Test
    public void test() {
        List<Attendance> attendances = this.attendanceMapper.selectList(Wrappers.lambdaQuery(Attendance.class).
                gt(Attendance::getAttendanceId, 1).
                gt(Attendance::getProjectId, 10)
        );
        System.out.println(attendances);
    }

    @Test
    public void test1() {
        List<AttendanceRecord> attendance = this.attendanceMapper.queryAttendance_0(LocalDateTime.now());
    }

}
