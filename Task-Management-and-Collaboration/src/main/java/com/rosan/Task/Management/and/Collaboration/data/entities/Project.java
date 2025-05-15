package com.rosan.Task.Management.and.Collaboration.data.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Projects")
public class Project {

    @Id
    private String id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Client Name", nullable = false)
    private String clientname;

    @Column(name = "Started At", nullable = false)
    private Date startdate;

    @Column(name = "Ended At")
    private Date enddate;


    @Column(name = "Created At", updatable = false)
    private Date createdat;

    @Column(name = "Updated At")
    private Date updatedat;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks = new ArrayList<>();


    @OneToMany(mappedBy = "project")
    private List<User> users = new ArrayList<>();

    public Project() {
    }

    public Project(String id, String name, String clientname, Date startdate, Date enddate, Date createdat, Date updatedat, List<Task> tasks, List<User> users) {
        this.id = id;
        this.name = name;
        this.clientname = clientname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.tasks = tasks;
        this.users = users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
