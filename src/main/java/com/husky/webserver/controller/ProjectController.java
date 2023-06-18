package com.husky.webserver.controller;

import com.husky.webserver.model.Project;
import com.husky.webserver.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/register")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @PostMapping("/compilation-time")
    public void registerCompilationTime(@ModelAttribute Project project) {
        projectService.add(project);
    }

    @GetMapping("/projects")
    public Collection<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping("/failed-results")
    public int failedResultCount() {
        return projectService.failedResultCount();
    }

    @GetMapping("/success-result")
    public int successResultCount() {
        return projectService.successResultCount();
    }

    @GetMapping("/long-compilation")
    public int longCompilationCount() {
        return projectService.longCompilationCount();
    }

    @GetMapping("/normal -compilation")
    public int normalCompilationCount() {
        return projectService.normalCompilationCount();
    }
}
