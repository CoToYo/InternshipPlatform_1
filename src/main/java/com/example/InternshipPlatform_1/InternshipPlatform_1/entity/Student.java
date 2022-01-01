package com.example.InternshipPlatform_1.InternshipPlatform_1.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("Student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer studentId;

    private String studentName;

    private Integer projectId;

    private String status;


}
