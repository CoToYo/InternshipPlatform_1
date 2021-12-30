package com.example.InternshipPlatform_1.InternshipPlatform_1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

//专用于返回考勤记录的类
public class AttendanceRecord implements Serializable {
    private Integer studentId;
    private String studentName;
    private String projectName;
    private LocalDateTime attendanceTime;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDateTime getAttendanceTime() {
        return attendanceTime;
    }

    public void setAttendanceTime(LocalDateTime attendanceTime) {
        this.attendanceTime = attendanceTime;
    }
}
