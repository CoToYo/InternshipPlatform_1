package com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo;

import lombok.Data;

@Data
public class Todo {
    private static final long serialVersionUID = 1L;

    // true已办，待办false
    private Boolean doStatus;

    // true已阅，待阅false
    private Boolean readStatus;

    // 日报周报月报
    private Integer type;

    // 具体任务
    private String detail;
}
