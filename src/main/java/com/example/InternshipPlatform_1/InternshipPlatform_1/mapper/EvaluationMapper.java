package com.example.InternshipPlatform_1.InternshipPlatform_1.mapper;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Evaluation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Mapper
public interface EvaluationMapper extends BaseMapper<Evaluation> {
    User selectByUserName(String userName);
}
