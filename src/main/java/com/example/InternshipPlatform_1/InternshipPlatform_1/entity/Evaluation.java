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
@TableName("Evaluation")
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "evalutation_id", type = IdType.AUTO)
    private Integer evalutationId;

    private LocalDateTime evaluationTime;

    private String evaluationContent;

    private Integer evaluatorId;

    private Integer appraiseeId;

    private Integer projectId;


}
