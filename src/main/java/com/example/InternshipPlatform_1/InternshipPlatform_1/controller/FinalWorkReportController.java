package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.FinalWorkReport;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IFinalWorkReportService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl.FinalWorkReportServiceImpl;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author harry
 * @since 2022-01-02
 */
@RestController
@RequestMapping("/InternshipPlatform_1/finalWorkReport")
@Api(tags = "实习报告，显示")
public class FinalWorkReportController {

    @Autowired
    private IFinalWorkReportService finalWorkReportService;

    @ApiOperation(value = "上传实习报告")
    @PostMapping("newOne")
    public R newOne(@RequestBody FinalWorkReport finalWorkReport) {
        User user = UserHolder.getUser();
        R r = new R();
        finalWorkReport.setStudentId(user.getUserId());
        r.setData(finalWorkReportService.newOne(finalWorkReport));
        return r;
    }

    @ApiOperation(value = "返回实习报告")
    @GetMapping("teacherGetOne")
    public R getOne() {
        User user = UserHolder.getUser();
        R r = new R();
        r.setData(finalWorkReportService.teacherGetOne(user.getUserId()));
        return r;
    }

}
