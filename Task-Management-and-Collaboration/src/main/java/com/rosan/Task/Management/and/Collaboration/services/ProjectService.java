package com.rosan.Task.Management.and.Collaboration.services;

import com.rosan.Task.Management.and.Collaboration.data.dtos.ProjectRequest;
import com.rosan.Task.Management.and.Collaboration.data.dtos.ProjectUpdateRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.Project;
import com.rosan.Task.Management.and.Collaboration.data.repositories.ProjectRepositroy;
import com.rosan.Task.Management.and.Collaboration.exceptions.ErrorWhileCreatingEntity;
import com.rosan.Task.Management.and.Collaboration.exceptions.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepositroy projectRepositroy;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<Project> getAll() {
        List<Project> projects = projectRepositroy.findAll();
        if (projects == null) {
            throw new NotFoundException("Error while Fetching the data!");
        }
        return projects;
    }

    @Override
    public Project addProject(ProjectRequest projectRequest) {
        Project project = new Project();
        project.setId(UUID.randomUUID().toString());
        project.setName(projectRequest.getName());
        project.setClientname(projectRequest.getClientname());
        project.setStartdate(projectRequest.getStartdate());
        project.setEnddate(projectRequest.getEnddate());
        project.setCreatedat(new Date());
        project.setUpdatedat(new Date());
        try {
            projectRepositroy.save(project);
            return project;
        } catch (ErrorWhileCreatingEntity ex) {
            throw new ErrorWhileCreatingEntity("Unable to add Project.Try after sometime");
        }
    }

    @Override
    public Project getSingleProject(String id) {
        Project project = projectRepositroy.findById(id).orElseThrow(() -> new NotFoundException("Project Not Found."));
        return project;
    }


    @Override
    public Project update(ProjectUpdateRequest projectUpdateRequest, String id) {
        Project project = projectRepositroy.findById(id).orElseThrow(() -> new NotFoundException("Project Not Found."));
        project.setName(projectUpdateRequest.getName());
        project.setClientname(projectUpdateRequest.getClientname());
        project.setEnddate(projectUpdateRequest.getEnddate());
        project.setUpdatedat(new Date());
        try {
            projectRepositroy.save(project);
            return project;
        } catch (ErrorWhileCreatingEntity ex) {
            throw new ErrorWhileCreatingEntity("Something went wrong.");
        }
    }

    @Override
    public void delete(String id) {
        Project project = projectRepositroy.findById(id).orElseThrow(()->new NotFoundException("Project Not Found."));
        try{
            projectRepositroy.delete(project);
        }catch(ErrorWhileCreatingEntity ex){
            throw new ErrorWhileCreatingEntity("Not Able Delete.");
        }
    }
}
