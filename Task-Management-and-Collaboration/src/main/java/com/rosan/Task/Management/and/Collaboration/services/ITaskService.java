package com.rosan.Task.Management.and.Collaboration.services;

import com.rosan.Task.Management.and.Collaboration.data.dtos.TaskRequest;
import com.rosan.Task.Management.and.Collaboration.data.dtos.TaskUpdateRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.Task;

import java.util.List;

public interface ITaskService {
    List<Task> getAll();
    Task getSingle(String id);
    Task addTask(TaskRequest taskRequest);
    Task update(TaskUpdateRequest taskRequest,String id);
    Boolean delete(String id);
    void assignTask(String taskid , String userid);

}
