package com.rosan.Task.Management.and.Collaboration.controllers;

import com.rosan.Task.Management.and.Collaboration.data.dtos.ApiResponse;
import com.rosan.Task.Management.and.Collaboration.data.dtos.Empty;
import com.rosan.Task.Management.and.Collaboration.data.dtos.ProjectRequest;
import com.rosan.Task.Management.and.Collaboration.data.dtos.ProjectUpdateRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.Project;
import com.rosan.Task.Management.and.Collaboration.services.IProjectService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectsController {

    @Autowired
    private IProjectService projectService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Project>>> getAllProjects(){
        List<Project> projects =  projectService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"SuccessFully Fetched Data",projects,new Date()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Project>> addProject(@RequestBody @Valid ProjectRequest projectRequest){
        Project project = projectService.addProject(projectRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<Project>(201,"Project Added Successfully",project,new Date()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Project>> getSingleProject(@PathVariable String id){
        Project project = projectService.getSingleProject(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"Project fetched Successfully",project,new Date()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Project>> updateProject(@RequestBody @Valid ProjectUpdateRequest projectUpdateRequest,@PathVariable String id){
        Project response = projectService.update(projectUpdateRequest,id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"Updated Sucessfully",response,new Date()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteProject(@PathVariable String id){
        projectService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse<>(204,"Deleted Successfully",new Empty(),new Date()));
    }
}
