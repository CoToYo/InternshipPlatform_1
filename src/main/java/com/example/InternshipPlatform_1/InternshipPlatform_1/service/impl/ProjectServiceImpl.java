package com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.example.InternshipPlatform_1.InternshipPlatform_1.mapper.ProjectMapper;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements IProjectService {

    @Autowired
    ProjectMapper projectMapper;

    public List<Project> getSuggestion(String projectType){
        List<Project> suggestion = new ArrayList<>();
        suggestion = projectMapper.querySuggestion(projectType);
        System.out.println("suggestion: "+suggestion);
        return suggestion;
    }
}
