package com.rosan.Task.Management.and.Collaboration.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Tasks")
public class Task {

    @Id
    private String id;

    @Column(name = "Title",nullable = false)
    private String title;

    @Column(name = "Description",nullable = true)
    private String description;

    @Column(name = "Due Date",nullable = false)
    private Date duedate;

    @Column(name = "Status",nullable = false)
    private Status status = Status.PENDING;

    @Column(name = "Created At", updatable = false)
    private Date createdat;

    @Column(name = "Updated At")
    private Date updatedat;

}
