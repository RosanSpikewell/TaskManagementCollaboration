package com.rosan.Task.Management.and.Collaboration.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Projects")
public class Project {

    @Id
    private String id;

    @Column(name = "Name",nullable = false)
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
}
