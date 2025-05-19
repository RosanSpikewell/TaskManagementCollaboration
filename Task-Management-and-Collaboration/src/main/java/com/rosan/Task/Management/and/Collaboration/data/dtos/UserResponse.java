package com.rosan.Task.Management.and.Collaboration.data.dtos;


import com.rosan.Task.Management.and.Collaboration.data.entities.Project;
import com.rosan.Task.Management.and.Collaboration.data.entities.Task;

import java.util.Date;
import java.util.List;

public class UserResponse {

    private String id;

    private String firstname;


    private String middlename;


    private String lastname;


    private String email;


    private String roles;

    private Date createdAt;
    private Date updatedAt;

    private Project project;

    private List<Task> tasks;

    public UserResponse() {
    }

    public UserResponse(String id, String firstname, String middlename, String lastname, String email, String roles, Date createdAt, Date updatedAt, Project project, List<Task> tasks) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.roles = roles;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.project = project;
        this.tasks = tasks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", roles='" + roles + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", project=" + project +
                ", tasks=" + tasks +
                '}';
    }
}
