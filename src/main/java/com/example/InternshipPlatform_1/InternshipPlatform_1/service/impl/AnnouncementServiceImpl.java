package com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Announcement;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Student;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo.AnnouncementRequest;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.AnnouncementMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IAnnouncementService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IProjectService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IStudentService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement> implements IAnnouncementService {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IAnnouncementService announcementService;

    @Autowired
    private IProjectService projectService;

    @Override
    public List<Announcement> getTeamAnnouncement(AnnouncementRequest announcementRequest) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper();
        queryWrapper.eq("studentId", announcementRequest.getListenerId());
        List<Student> list = studentService.list(queryWrapper);
        List<Announcement> announcements = null;

        for (Student stu : list) {
            QueryWrapper<Project> projectQueryWrapper = new QueryWrapper();
            projectQueryWrapper.eq("projectId", stu.getProjectId());
            List<Project> projects = projectService.list(projectQueryWrapper);
            for (Project pro : projects) {
                QueryWrapper<Announcement> announcementQueryWrapper = new QueryWrapper();
                announcementQueryWrapper.orderByDesc("announceTime");
                announcementQueryWrapper.eq("publisherId", pro.getProjectId());
                announcements.addAll(announcementService.list(announcementQueryWrapper));
            }
        }
        return announcements;
    }
}
