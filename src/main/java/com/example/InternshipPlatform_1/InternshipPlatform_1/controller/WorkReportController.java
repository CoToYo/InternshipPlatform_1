package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.WorkReport;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.WorkReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
@ResponseBody
@RequestMapping(value = "/InternshipPlatform_1/work-report", produces = "application/json;charset=UTF-8")
public class WorkReportController {
    @Autowired
    WorkReportMapper workReportMapper;

    LocalDateTime present_time = LocalDateTime.now();

    @PostMapping(value = "/confirm", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String insertReport(@RequestBody WorkReport report){

        report.setReportTime(present_time); //后台记录报告上传时间
        int insert = workReportMapper.insert(report); //向数据库对应位置写入收到的报告

        return "WorkReport has been uploaded! WorkReport type is: "+report.getReportType();
    }

}
