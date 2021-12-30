package com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AnnouncementAndProject extends Project {
    @TableId(value = "announce_id", type = IdType.AUTO)
    private Integer announceId;

    private String announceContent;

    private LocalDateTime announceTime;

    private Integer publisherId;

    private Integer listenerId;
}
