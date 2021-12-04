package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Announcement;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
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

    @GetMapping("getTeamAnnouncement/{teamId}")
    public R getTeamAnnouncement(@RequestBody AnnouncementRequest announcementRequest) {
        announcementService.getTeamAnnouncement(announcementRequest);
        R r = new R();
        r.setCode(111);
        r.setData("111");
        r.setMsg("111");
        return r;
    }
}
