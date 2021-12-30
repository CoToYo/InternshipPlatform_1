package com.example.InternshipPlatform_1.InternshipPlatform_1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
@TableName("WorkReport")
public class WorkReport implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "report_id", type = IdType.AUTO)
    private Integer reportId;

    private Integer studentId;

    private LocalDateTime reportTime;

    private String completedContent;

    private String incompletedContent;

    private String solutionContent;

    private String futureContent;

    private String reportType;


}
