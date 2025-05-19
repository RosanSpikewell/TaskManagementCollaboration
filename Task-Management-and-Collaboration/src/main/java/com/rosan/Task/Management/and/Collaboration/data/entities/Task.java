package com.rosan.Task.Management.and.Collaboration.data.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    private String id;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "Description", nullable = true)
    private String description;

    @Column(name = "Due Date", nullable = false)
    private Date duedate;

    @Column(name = "Status", nullable = false)
    private Status status = Status.PENDING;

    @Column(name = "Created At", updatable = false)
    private Date createdat;

    @Column(name = "Updated At")
    private Date updatedat;


    @ManyToOne
    private User user;


    @JsonManagedReference
    @ManyToOne
    private Project project;

    public Task() {
    }

    public Task(String id, String title, String description, Date duedate, Status status, Date createdat, Date updatedat, User user, Project project) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duedate = duedate;
        this.status = status;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.user = user;
        this.project = project;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duedate=" + duedate +
                ", status=" + status +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                ", user=" + user +
                ", project=" + project +
                '}';
    }
}
