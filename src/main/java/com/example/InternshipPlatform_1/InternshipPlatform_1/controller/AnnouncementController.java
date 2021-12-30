package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Announcement;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo.AnnouncementRequest;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/InternshipPlatform_1/announcement")
@CrossOrigin
public class AnnouncementController {
    @Autowired
    IAnnouncementService announcementService;

    @GetMapping("getTeamAnnouncement")
    public R getTeamAnnouncement(@RequestBody AnnouncementRequest announcementRequest) {
        R r = new R();
        r.setData(announcementService.getTeamAnnouncement(announcementRequest));
        return r;
    }

    @GetMapping("getSystemAnnouncement")
    public R getSystemAnnouncement() {
        R r = new R();
        r.setData(announcementService.getSystemAnnouncement());
        return r;
    }

    @GetMapping("getTodo")
    public R getTodo(@RequestBody AnnouncementRequest announcementRequest) {
        R r = new R();
        r.setData(announcementService.getTodo(announcementRequest));
        return r;
    }

    @PostMapping("newTeamAnnouncement")
    public R newTeamAnnouncement(@RequestBody Announcement announcement) {
        R r = new R();
        r.setData(announcementService.newTeamAnnouncement(announcement));
        return r;
    }

    @PostMapping("getGroup")
    public R getGroup(@RequestBody AnnouncementRequest announcementRequest) {
        R r = new R();
        r.setData(announcementService.getGroup(announcementRequest.getListenerId()));
        return r;
    }

    @PostMapping("getListeners")
    public R getListeners(@RequestBody Project project) {
        R r = new R();
        r.setData(announcementService.getListeners(project));
        return r;
    }

    @DeleteMapping("deleteAnnouncement/{announcementId}")
    public R deleteAnnouncement(@PathVariable("announcementId") String announcementId) {
        R r = new R();
        r.setData(announcementService.deleteAnnouncement(announcementId));
        return r;
    }
}
