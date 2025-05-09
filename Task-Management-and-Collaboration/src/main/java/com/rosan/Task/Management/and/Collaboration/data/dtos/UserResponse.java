package com.rosan.Task.Management.and.Collaboration.data.dtos;


import java.util.Date;

public class UserResponse {

    private String id;

    private String firstname;


    private String middlename;


    private String lastname;


    private String email;


    private String roles;

    private Date createdAt;
    private Date updatedAt;

    public UserResponse() {

    }

    public UserResponse(String id, Date updatedAt, Date createdAt, String roles, String email, String lastname, String middlename, String firstname) {
        this.id = id;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.roles = roles;
        this.email = email;
        this.lastname = lastname;
        this.middlename = middlename;
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", roles='" + roles + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
