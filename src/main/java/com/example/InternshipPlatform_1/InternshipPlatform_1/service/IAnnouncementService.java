package com.example.InternshipPlatform_1.InternshipPlatform_1.service;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Announcement;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo.AnnouncementRequest;
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

    List<Announcement> getTeamAnnouncement(AnnouncementRequest announcementRequest);

    List<Announcement> getSystemAnnouncement();

    List<Todo> getTodo(AnnouncementRequest announcementRequest);
}
