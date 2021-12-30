package com.example.InternshipPlatform_1.InternshipPlatform_1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("Announcement")
@ApiModel(value = "公告类", description = "公告实体含有的信息")
public class Announcement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "announce_id", type = IdType.AUTO)
    @ApiModelProperty(value = "公告id")
    private Integer announceId;

    @ApiModelProperty(value = "公告内容", required = true)
    private String announceContent;

    @ApiModelProperty(value = "发布的时间", required = true)
    private LocalDateTime announceTime;

    @ApiModelProperty(value = "发布人的id", required = true)
    private Integer publisherId;

    @ApiModelProperty(value = "接收人的id", required = true)
    private Integer listenerId;


}
