package com.rosan.Task.Management.and.Collaboration.data.dtos;

import jakarta.validation.constraints.NotBlank;

public class ChangePasswordDto {

    @NotBlank
    private String newpassword;
    @NotBlank
    private String confirmpassword;

    public ChangePasswordDto() {
    }

    public ChangePasswordDto(String newpassword, String confirmpassword) {
        this.newpassword = newpassword;
        this.confirmpassword = confirmpassword;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    public String getConfirmpassword() {
        return confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        this.confirmpassword = confirmpassword;
    }

}
