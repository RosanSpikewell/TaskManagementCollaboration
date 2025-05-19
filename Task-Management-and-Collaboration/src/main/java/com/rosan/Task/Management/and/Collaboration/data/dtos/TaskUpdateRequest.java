package com.rosan.Task.Management.and.Collaboration.data.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class TaskUpdateRequest {

    @NotBlank(message = "Title is required.")
    private String title;

    @NotBlank(message = "Description is Required")
    private String description;

    @Future
    private Date duedate;

    public TaskUpdateRequest() {
    }

    public TaskUpdateRequest(String title, String description, Date duedate) {
        this.title = title;
        this.description = description;
        this.duedate = duedate;
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
}
