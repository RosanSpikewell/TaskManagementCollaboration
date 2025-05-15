package com.rosan.Task.Management.and.Collaboration.services;

import com.rosan.Task.Management.and.Collaboration.data.dtos.ChangePasswordDto;
import com.rosan.Task.Management.and.Collaboration.data.dtos.UserRequest;
import com.rosan.Task.Management.and.Collaboration.data.dtos.UserResponse;
import com.rosan.Task.Management.and.Collaboration.data.dtos.UserUpdateRequest;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IUserService {
    public List<UserResponse> getAll();
    public UserResponse getSingle(String id);
    public UserResponse create(UserRequest userRequest,BindingResult result);
    public UserResponse update(UserUpdateRequest userRequest, String id, BindingResult result);
    public UserResponse delete(String id);
    public void updatePassword(ChangePasswordDto passwordDto,String id,BindingResult result);
    void assignProject(String userid,String projectid);
}
