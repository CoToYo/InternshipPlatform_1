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
@TableName("Leave")
public class Leave implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    private LocalDateTime askTime; //请假申请发出时间

    private LocalDateTime leaveTime; //申请什么时间请假

    private LocalDateTime backTime; // 请假结束时间

    private String reason; //请假理由

    private Integer approverId; //批准人ID

    private String applicantName; //请假人的姓名

    private Integer applicantId; // 请假人ID


}
