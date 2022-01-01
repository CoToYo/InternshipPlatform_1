package com.example.InternshipPlatform_1.InternshipPlatform_1.service;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Student;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo.Todo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
public interface IAnnouncementService extends IService<Announcement> {

    List<Announcement> getTeamAnnouncement(Integer userId);

    List<Announcement> getSystemAnnouncement();

    List<Todo> getTodo(Integer userId);

    Boolean newTeamAnnouncement(Announcement announcement);

    List<Project> getGroup(Integer listenerId);

    List<Student> getListeners(Integer groupId);

    Boolean deleteAnnouncement(Integer announcementId);

}
