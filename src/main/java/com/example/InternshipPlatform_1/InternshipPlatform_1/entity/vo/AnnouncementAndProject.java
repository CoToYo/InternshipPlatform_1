package com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementAndProject extends Project {
    @TableId(value = "announce_id", type = IdType.AUTO)
    @ApiModelProperty(value = "公告id")
    private Integer announceId;

    @ApiModelProperty(value = "公告内容")
    private String announceContent;

    @ApiModelProperty(value = "公告时间")
    private LocalDateTime announceTime;

    @ApiModelProperty(value = "发布人id")
    private Integer publisherId;

    @ApiModelProperty(value = "接收人id")
    private Integer listenerId;
}
