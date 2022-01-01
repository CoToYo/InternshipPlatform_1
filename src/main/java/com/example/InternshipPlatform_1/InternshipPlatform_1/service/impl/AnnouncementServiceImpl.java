package com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.*;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo.Todo;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.AnnouncementMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.InternshipPlatform_1.InternshipPlatform_1.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    private IUserService userService;

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IWorkReportService workReportService;

    @Override
    public List<Announcement> getTeamAnnouncement(Integer userId) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper();
        queryWrapper.eq("student_id", userId);
        List<Student> list = studentService.list(queryWrapper);
        List<Announcement> announcements = new ArrayList<Announcement>();

        System.out.println(list);

        for (Student stu : list) {
            QueryWrapper<Project> projectQueryWrapper = new QueryWrapper();
            projectQueryWrapper.eq("project_id", stu.getProjectId());
            List<Project> projects = projectService.list(projectQueryWrapper);
//            System.out.println(projects);
            for (Project pro : projects) {
                QueryWrapper<Announcement> announcementQueryWrapper = new QueryWrapper();
                announcementQueryWrapper.orderByDesc("announce_time");
                announcementQueryWrapper.eq("publisher_id", pro.getLeaderId());
                announcements.addAll(this.list(announcementQueryWrapper));
            }
        }
        return announcements;
    }

    @Override
    public List<Announcement> getSystemAnnouncement() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper();
        userQueryWrapper.eq("role", 40);
        List<User> users = userService.list(userQueryWrapper);
        List<Announcement> announcements = new ArrayList<Announcement>();
        for (User user : users) {
            QueryWrapper<Announcement> announcementQueryWrapper = new QueryWrapper();
            announcementQueryWrapper.eq("publisher_id", user.getUserId());
            announcements.addAll(this.list(announcementQueryWrapper));
        }
        return announcements;
    }

//    private static int getWeekOfDate(Date dt) {
//        int[] weekDays = {7, 1, 2, 3, 4, 5, 6};
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(dt);
//        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
//        if (w < 0) {
//            w = 0;
//        }
//        return weekDays[w];
//    }

    @Override
    public List<Todo> getTodo(Integer userId) {
        QueryWrapper<WorkReport> dailyWorkReportQueryWrapper = new QueryWrapper();
        QueryWrapper<WorkReport> weeklyWorkReportQueryWrapper = new QueryWrapper();
        QueryWrapper<WorkReport> monthlyWorkReportQueryWrapper = new QueryWrapper();
        Date date = new Date();
        int day = date.getDay() - 1;
        int monthDay = date.getDate() - 1;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        dailyWorkReportQueryWrapper.eq("student_id", userId)
                .eq("report_time", df.format(date));

        weeklyWorkReportQueryWrapper.eq("student_id", userId)
                .between("report_time", df.format(new Date(date.getTime()-(long)day*24*60*60*1000)), date);

        monthlyWorkReportQueryWrapper.eq("student_id", userId)
                .between("report_time", df.format(new Date(date.getTime()-(long)monthDay*24*60*60*1000)), date);

        List<WorkReport> dailyWorkReports = workReportService.list(dailyWorkReportQueryWrapper);
        List<WorkReport> weeklyWorkReports = workReportService.list(weeklyWorkReportQueryWrapper);
        List<WorkReport> monthlyWorkReports = workReportService.list(monthlyWorkReportQueryWrapper);

        Todo dailyTodo = new Todo();
        dailyTodo.setType(0);
        dailyTodo.setDetail("日报提醒");
        Todo weeklyTodo = new Todo();
        weeklyTodo.setType(1);
        weeklyTodo.setDetail("周报提醒");
        Todo monthlyTodo = new Todo();
        monthlyTodo.setType(2);
        monthlyTodo.setDetail("月报提醒");

        if (dailyWorkReports.isEmpty()) {
            dailyTodo.setDoStatus(false);
            dailyTodo.setReadStatus(false);
        } else {
            dailyTodo.setDoStatus(true);
            dailyTodo.setReadStatus(true);
        }
        if (weeklyWorkReports.isEmpty()) {
            weeklyTodo.setReadStatus(true);
            weeklyTodo.setDoStatus(true);
        }
        if (monthlyWorkReports.isEmpty()) {
            monthlyTodo.setDoStatus(true);
            monthlyTodo.setReadStatus(true);
        }

        List<Todo> todos = new ArrayList<Todo>();
        todos.add(dailyTodo);
        todos.add(weeklyTodo);
        todos.add(monthlyTodo);
        return todos;
    }

    @Override
    public Boolean newTeamAnnouncement(Announcement announcement) {
        User user = UserHolder.getUser();
        announcement.setPublisherId(user.getUserId());
        return this.save(announcement);
    }

    @Override
    public List<Project> getGroup(Integer myId) {
        QueryWrapper<Project> projectQueryWrapper = new QueryWrapper<Project>();
        projectQueryWrapper.eq("leader_id", myId);
        List<Project> projects = projectService.list(projectQueryWrapper);
        return projects;
    }

    @Override
    public List<Student> getListeners(Integer groupId) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<Student>();
        studentQueryWrapper.eq("project_id", groupId);
        List<Student> students = studentService.list(studentQueryWrapper);
        return students;
    }

    @Override
    public Boolean deleteAnnouncement(Integer announcementId) {
        return this.removeById(announcementId);
    }


}















