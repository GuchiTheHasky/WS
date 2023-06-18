package com.husky.webserver.repository;

import com.husky.webserver.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class ProjectRepository {
    private List<Project> projects = new ArrayList<>();

    public Collection<Project> findAll() {
        return Collections.unmodifiableList(projects);
    }

    public void add(Project project) {
        projects.add(project);
    }

    public int failedResultCount() {
        int count = 0;
        for (Project project : projects) {
            if (project.getResult().equalsIgnoreCase("failed")) {
                count++;
            }
        }
        return count;
    }

    public int successResultCount() {
        int count = 0;
        for (Project project : projects) {
            if (project.getResult().equalsIgnoreCase("success")) {
                count++;
            }
        }
        return count;
    }

    public int longCompilationCount() {
        int count = 0;
        for (Project project : projects) {
            if (project.getCompilationTime() >= 1000) {
                count++;
            }
        }
        return count;
    }

    public int normalCompilationCount() {
        int count = 0;
        for (Project project : projects) {
            if (project.getCompilationTime() < 1000) {
                count++;
            }
        }
        return count;
    }
}
