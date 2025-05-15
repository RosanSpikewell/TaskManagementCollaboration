package com.rosan.Task.Management.and.Collaboration.data.dtos;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ProjectRequest {
    @NotBlank(message = "Name is requireded.")
    private String name;
    @NotBlank(message = "Client Name is required.")
    private String clientname;

    @NotNull(message = "Start Date is required")
    @FutureOrPresent(message = "Please Enter a valid date.")
    private Date startdate;

    @Future(message = "Please Enter a Valid Date.")
    private Date enddate;

    public ProjectRequest() {
    }

    public ProjectRequest(String name, String clientname, Date startdate, Date enddate) {
        this.name = name;
        this.clientname = clientname;
        this.startdate = startdate;
        this.enddate = enddate;
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
}
