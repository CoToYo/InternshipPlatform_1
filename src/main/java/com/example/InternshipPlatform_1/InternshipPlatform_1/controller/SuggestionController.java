package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;

import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.IProjectService;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl.ProjectServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cty
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/InternshipPlatform_1/project")
public class SuggestionController {
    @Autowired
    private ProjectServiceImpl projectServiceImpl;



    @GetMapping("/suggest")
    public List<Project> suggestion(@RequestParam("projectType") String projectType) {
        System.out.println(projectType);
        List<Project> suggestion = projectServiceImpl.getSuggestion(projectType);
        System.out.println(suggestion);
        return suggestion;
    }
}
