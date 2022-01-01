package com.example.InternshipPlatform_1.InternshipPlatform_1.controller;


import com.example.InternshipPlatform_1.InternshipPlatform_1.entity.Project;
import com.example.InternshipPlatform_1.InternshipPlatform_1.result.Result;
import com.example.InternshipPlatform_1.InternshipPlatform_1.service.impl.ProjectServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class ProjectController {

    private final ProjectServiceImpl projectService;

    public ProjectController(ProjectServiceImpl projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/publish")
    public Result publish(@RequestBody Project project) {
        System.out.println("publish a project:");
        System.out.println(project);
        if (projectService.save(project)){
            return new Result(200);
        }else {
            return new Result(400);
        }

    }
}
