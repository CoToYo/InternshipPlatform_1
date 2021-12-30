package com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class AnnouncementRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前用户的id", required = true)
    private Integer id;
}
