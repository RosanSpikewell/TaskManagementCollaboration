package com.rosan.Task.Management.and.Collaboration.controllers;

import com.rosan.Task.Management.and.Collaboration.data.dtos.ApiResponse;
import com.rosan.Task.Management.and.Collaboration.data.dtos.Empty;
import com.rosan.Task.Management.and.Collaboration.data.dtos.TaskRequest;
import com.rosan.Task.Management.and.Collaboration.data.dtos.TaskUpdateRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.Task;
import com.rosan.Task.Management.and.Collaboration.services.ITaskService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    @Autowired
    private ITaskService taskService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Task>>> getAllTasks(){
        List<Task> tasks = taskService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"Tasks Fetched Successfully",tasks,new Date()));
    }


    @GetMapping("/{taskid}")
    public ResponseEntity<ApiResponse<Task>> getTask(@PathVariable  String taskid){
        Task task = taskService.getSingle(taskid);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"Tasks Fetched Successfully",task,new Date()));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<Task>> addTask(@RequestBody @Valid TaskRequest taskRequest)
    {
        Task task = taskService.addTask(taskRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(201,"Task Created Successfully",task,new Date()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Task>> updateTask(@RequestBody @Valid TaskUpdateRequest taskRequest , @PathVariable  String id){
        Task task = taskService.update(taskRequest,id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"Task Updated Successfully",task,new Date()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deleteTask(@PathVariable String id){
        Boolean response = taskService.delete(id);
        if(response)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        else
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse<>(500,"Something went wrong",new Empty(),new Date()));
    }

    @PatchMapping("/{taskid}/users/{userid}")
    public ResponseEntity<ApiResponse<?>> assignTask(@PathVariable String taskid,@PathVariable String userid){
       taskService.assignTask(taskid,userid);
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"Task Assigned Successfully.",new Empty(),new Date()));
    }
}
