package com.example.InternshipPlatform_1.InternshipPlatform_1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

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
@TableName("Project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "项目id")
    @TableId(value = "project_id", type = IdType.AUTO)
    private Integer projectId;

    @ApiModelProperty(value = "发布项目时间", required = true)
    private LocalDateTime publishedTime;

    @ApiModelProperty(value = "项目开始时间", required = true)
    private LocalDateTime startTime;

    @ApiModelProperty(value = "时间长度",required = true)
    private Integer duration;

    @ApiModelProperty(value = "项目内容", required = true)
    private String projectProfile;

    @ApiModelProperty(value = "主管人id", required = true)
    private Integer leaderId;

    @ApiModelProperty(value = "机构id", required = true)
    private Integer institutionId;

    @ApiModelProperty(value = "项目名称", required = true)
    private String projectName;

    @ApiModelProperty(value = "项目项目类型", required = true)
    private int projectType;


}
