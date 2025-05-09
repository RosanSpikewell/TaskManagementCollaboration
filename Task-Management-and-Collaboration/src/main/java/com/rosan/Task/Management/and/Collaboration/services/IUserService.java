package com.rosan.Task.Management.and.Collaboration.services;

import com.rosan.Task.Management.and.Collaboration.data.entities.User;
import com.rosan.Task.Management.and.Collaboration.data.entities.UserRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface IUserService {
    public List<UserResponse> getAll();
    public UserResponse getSingle(String id);
    public UserResponse create(UserRequest userRequest,BindingResult result);
    public UserResponse update(UserRequest userRequest,String id);
    public UserResponse delete(String id);


}
