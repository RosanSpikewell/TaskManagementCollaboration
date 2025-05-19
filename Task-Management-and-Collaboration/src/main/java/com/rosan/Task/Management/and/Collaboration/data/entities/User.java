package com.rosan.Task.Management.and.Collaboration.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    @Column(name = "Email", nullable = false,unique = true)
    private String email;

    @Column(name = "Password", nullable = false)
    private String password;


    @Column(name = "Role", nullable = false, updatable = false)
    private String roles;

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


    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Task> tasks = new ArrayList<>();


    @JsonManagedReference
    @ManyToOne
    private Project project;

    public User() {
    }

    public User(String id, String firstname, String middlename, String lastname, String email, String password, String roles, Boolean isActive, Date createdat, Date updatedat) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.isActive = isActive;
        this.createdat = createdat;
        this.updatedat = updatedat;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", isActive=" + isActive +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                ", tasks=" + tasks +
                ", project=" + project +
                '}';
    }
}
