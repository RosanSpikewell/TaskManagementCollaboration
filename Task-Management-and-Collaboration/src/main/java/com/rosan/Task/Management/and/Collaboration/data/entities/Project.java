package com.rosan.Task.Management.and.Collaboration.data.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Projects")
@Builder
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
}
