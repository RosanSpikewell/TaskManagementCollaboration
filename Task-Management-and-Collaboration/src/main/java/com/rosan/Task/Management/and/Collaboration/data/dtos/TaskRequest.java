package com.rosan.Task.Management.and.Collaboration.data.dtos;

import com.rosan.Task.Management.and.Collaboration.data.entities.Project;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class TaskRequest {

    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Description is Required")
    private String description;

    @Future
    private Date duedate;

    @NotBlank(message = "ProjectId is Required")
    private String  projectid;

    public TaskRequest() {
    }

    public TaskRequest(String title, String description, Date duedate, String projectid) {
        this.title = title;
        this.description = description;
        this.duedate = duedate;
        this.projectid = projectid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDuedate() {
        return duedate;
    }

    public void setDuedate(Date duedate) {
        this.duedate = duedate;
    }

    public String getProjectid() {
        return projectid;
    }

    public void setProjectid(String projectid) {
        this.projectid = projectid;
    }
}
