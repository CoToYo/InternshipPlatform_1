package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Announcement;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo.AnnouncementRequest;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IAnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "公告接口测试")
public class AnnouncementController {
    @Autowired
    IAnnouncementService announcementService;

    @ApiOperation(value = "获取当前用户的团队公告")
    @GetMapping("getTeamAnnouncement")
    public R getTeamAnnouncement(@RequestBody AnnouncementRequest announcementRequest) {
        R r = new R();
        r.setData(announcementService.getTeamAnnouncement(announcementRequest));
        return r;
    }

    @ApiOperation(value = "获取当前用户的系统公告")
    @GetMapping("getSystemAnnouncement")
    public R getSystemAnnouncement() {
        R r = new R();
        r.setData(announcementService.getSystemAnnouncement());
        return r;
    }

    @ApiOperation(value = "获取待办事项\n我们之前说的是只有日报周报月报的完成情况")
    @GetMapping("getTodo")
    public R getTodo(@RequestBody AnnouncementRequest announcementRequest) {
        R r = new R();
        r.setData(announcementService.getTodo(announcementRequest));
        return r;
    }

    @ApiOperation(value = "创建一个团队公告")
    @PostMapping("newTeamAnnouncement")
    public R newTeamAnnouncement(@RequestBody Announcement announcement) {
        R r = new R();
        r.setData(announcementService.newTeamAnnouncement(announcement));
        return r;
    }

    @ApiOperation(value = "获取当前用户领导的所有小组")
    @PostMapping("getGroup")
    public R getGroup(@RequestBody AnnouncementRequest announcementRequest) {
        R r = new R();
        r.setData(announcementService.getGroup(announcementRequest.getId()));
        return r;
    }

    @ApiOperation(value = "获取当前用户选择发布的小组的所有人")
    @PostMapping("getListeners")
    public R getListeners(@RequestBody Project project) {
        R r = new R();
        r.setData(announcementService.getListeners(project));
        return r;
    }

    @ApiOperation(value = "根据公告id删除公告")
    @DeleteMapping("deleteAnnouncement/{announcementId}")
    public R deleteAnnouncement(@PathVariable("announcementId") String announcementId) {
        R r = new R();
        r.setData(announcementService.deleteAnnouncement(announcementId));
        return r;
    }
}
