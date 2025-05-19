package com.rosan.Task.Management.and.Collaboration.services;

import com.rosan.Task.Management.and.Collaboration.data.dtos.TaskRequest;
import com.rosan.Task.Management.and.Collaboration.data.dtos.TaskUpdateRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.Project;
import com.rosan.Task.Management.and.Collaboration.data.entities.Status;
import com.rosan.Task.Management.and.Collaboration.data.entities.Task;
import com.rosan.Task.Management.and.Collaboration.data.entities.User;
import com.rosan.Task.Management.and.Collaboration.data.repositories.ProjectRepositroy;
import com.rosan.Task.Management.and.Collaboration.data.repositories.TaskRepository;
import com.rosan.Task.Management.and.Collaboration.data.repositories.UserRepository;
import com.rosan.Task.Management.and.Collaboration.exceptions.ErrorWhileCreatingEntity;
import com.rosan.Task.Management.and.Collaboration.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private TaskRepository taskRepository;


    @Autowired
    private ProjectRepositroy projectRepositroy;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Task> getAll() {
        try{
            List<Task> tasks = taskRepository.findAll();
            return tasks;
        }catch (NotFoundException ex){
            throw new NotFoundException("Error while fetching data.");
        }
    }

    @Override
    public Task getSingle(String id) {
       Task task = taskRepository.findById(id).orElseThrow(()->new NotFoundException("Task Not Found."));
       return task;
    }

    @Override
    public Task addTask(TaskRequest taskRequest) {

        Project project = projectRepositroy.findById(taskRequest.getProjectid()).orElseThrow(()->new NotFoundException("Project Not Found"));
        try {
            Task task = new Task();
            task.setId(UUID.randomUUID().toString());
            task.setTitle(taskRequest.getTitle());
            task.setDescription(taskRequest.getDescription());
            task.setDuedate(taskRequest.getDuedate());
            task.setCreatedat(new Date());
            task.setUpdatedat(new Date());
            task.setProject(project);
            taskRepository.save(task);
            return task;
        } catch (ErrorWhileCreatingEntity ex) {
            throw new ErrorWhileCreatingEntity("Error Occured while creating Task.");
        }
    }

    @Override
    public Task update(TaskUpdateRequest taskRequest,String id) {
       try{
           Task task = taskRepository.findById(id).orElseThrow(()->new NotFoundException("Task not Found."));
           task.setTitle(taskRequest.getTitle());
           task.setDescription(taskRequest.getDescription());
           task.setDuedate(taskRequest.getDuedate());
           task.setUpdatedat(new Date());
           taskRepository.save(task);
           return task;
       }catch (ErrorWhileCreatingEntity ex){
           throw new ErrorWhileCreatingEntity("Unable to update.");
       }
    }

    @Override
    public Boolean delete(String id) {
       Task task  = taskRepository.findById(id).orElseThrow(()->new NotFoundException("Task not Found."));
       try{
            taskRepository.delete(task);
            return true;
       }catch (Exception ex)
       {
           throw new ErrorWhileCreatingEntity("Something went Wrong.");
       }
    }

    @Override
    public void assignTask(String taskid, String userid) {
        Task task = taskRepository.findById(taskid).orElseThrow(()->new NotFoundException("Task Not Found"));
        User user = userRepository.findById(userid).orElseThrow(()->new NotFoundException("User Not Found"));

        try{
            if (task.getStatus().equals(Status.COMPLETED))
                throw new ErrorWhileCreatingEntity("The Task is Already Completed");
            task.setUser(user);
            task.setUpdatedat(new Date());
            taskRepository.save(task);
        }catch(ErrorWhileCreatingEntity ex){
            throw new ErrorWhileCreatingEntity("Error occured while assigning a task");
        }
    }
}
