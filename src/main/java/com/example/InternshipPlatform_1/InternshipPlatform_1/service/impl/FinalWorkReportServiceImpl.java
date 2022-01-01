package com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.FinalWorkReport;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Student;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.FinalWorkReportMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IFinalWorkReportService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IProjectService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author harry
 * @since 2022-01-02
 */
@Service
public class FinalWorkReportServiceImpl extends ServiceImpl<FinalWorkReportMapper, FinalWorkReport> implements IFinalWorkReportService {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IProjectService projectService;

    @Override
    public boolean newOne(FinalWorkReport finalWorkReport) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<Student>();
        studentQueryWrapper.eq("student_id", finalWorkReport.getStudentId());
        List<Student> students = studentService.list(studentQueryWrapper);
        for (Student stu : students) {
            finalWorkReport.setProjectId(stu.getProjectId());
        }
        return this.save(finalWorkReport);
    }

    @Override
    public FinalWorkReport getOne(Integer id) {
        QueryWrapper<FinalWorkReport> finalWorkReportQueryWrapper = new QueryWrapper<FinalWorkReport>();
        finalWorkReportQueryWrapper.eq("student_id", id);
        List<FinalWorkReport> list = this.list(finalWorkReportQueryWrapper);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
