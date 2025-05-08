package com.rosan.Task.Management.and.Collaboration.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import javax.management.relation.Role;
import java.util.Date;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    private String id;

    @Column(name = "FirstName", nullable = false)
    private String firstname;

    @Column(name = "MiddleName", nullable = true)
    private String middlename;

    @Column(name = "LastName", nullable = false)
    private String lastname;

    @Column(name = "Email", nullable = false)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;


    @Column(name = "Role",nullable = false,updatable = false)
    private Roles roles;

    @Column(name = "Is Active")
    private Boolean isActive = true;

    @Column(
            name = "Created At",
            updatable = false
    )
    private Date createdat;

    @Column(
            name = "Updated At"
    )
    private Date updatedat;

}
