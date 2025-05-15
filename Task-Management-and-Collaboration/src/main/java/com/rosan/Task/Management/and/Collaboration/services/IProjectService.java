package com.rosan.Task.Management.and.Collaboration.services;

import com.rosan.Task.Management.and.Collaboration.data.dtos.ProjectRequest;
import com.rosan.Task.Management.and.Collaboration.data.dtos.ProjectUpdateRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.Project;

import java.util.List;

public interface IProjectService {
    List<Project> getAll();

    Project addProject(ProjectRequest projectRequest);

    Project getSingleProject(String id);

    Project update(ProjectUpdateRequest projectUpdateRequest, String id);

    void delete(String id);
}
