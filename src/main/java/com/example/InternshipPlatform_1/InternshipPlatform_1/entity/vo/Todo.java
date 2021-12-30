package com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Todo {
    private static final long serialVersionUID = 1L;

    // true已办，待办false
    @ApiModelProperty(value = "是否已办")
    private Boolean doStatus;

    // true已阅，待阅false
    @ApiModelProperty(value = "是否已读")
    private Boolean readStatus;

    // 日报周报月报
    @ApiModelProperty(value = "待办类型")
    private Integer type;

    // 具体任务
    @ApiModelProperty(value = "具体任务")
    private String detail;
}
