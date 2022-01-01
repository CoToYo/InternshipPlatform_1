package com.example.InternshipPlatform_1.InternshipPlatform_1.service;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
public interface IProjectService extends IService<Project> {


    List<Project> getSuggestion(String projectType);

}
