package com.example.InternshipPlatform_1.InternshipPlatform_1.mapper;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Announcement;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.vo.AnnouncementAndProject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 *
 */
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {

    @Select("SELECT a.")
    List<AnnouncementAndProject> getAllLeadersGroup();
}
