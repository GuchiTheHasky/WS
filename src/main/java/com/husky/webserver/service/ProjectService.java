package com.husky.webserver.service;

import com.husky.webserver.exception.ProjectException;
import com.husky.webserver.model.Project;
import com.husky.webserver.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public void add(Project project) {
        if (project == null) {
            throw new ProjectException("Current project is null.");
        }
        projectRepository.add(project);
    }
    public Collection<Project> findAll() {
        if (projectRepository.findAll().isEmpty()) {
            throw new ProjectException("Current list is empty.");
        }
        return projectRepository.findAll();
    }
    public int failedResultCount() {
        return projectRepository.failedResultCount();
    }
    public int successResultCount() {
        return projectRepository.successResultCount();
    }
    public int longCompilationCount() {
        return projectRepository.longCompilationCount();
    }
    public int normalCompilationCount() {
        return projectRepository.normalCompilationCount();
    }
}
