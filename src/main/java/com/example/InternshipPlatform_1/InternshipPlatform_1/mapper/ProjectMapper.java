package com.example.InternshipPlatform_1.InternshipPlatform_1.mapper;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Mapper
public interface ProjectMapper extends BaseMapper<Project> {
    List<Project> querySuggestion(@Param("project_type")String projectType);//查询对应项目类型的项目的sql查询方法
}
