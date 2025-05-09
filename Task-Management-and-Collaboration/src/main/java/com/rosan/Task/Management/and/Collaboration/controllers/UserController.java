package com.rosan.Task.Management.and.Collaboration.controllers;

import com.rosan.Task.Management.and.Collaboration.data.entities.ApiResponse;
import com.rosan.Task.Management.and.Collaboration.data.entities.UserRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.UserResponse;
import com.rosan.Task.Management.and.Collaboration.services.IUserService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUser(){
        List<UserResponse> users = userService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(200, "User Details Fetched Successfully", users, new Date()));
    }

    @GetMapping("/{userid}")
    public ResponseEntity<ApiResponse<UserResponse>> getSingleUser(@PathVariable String userid){
        UserResponse userResponse = userService.getSingle(userid);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"User Fetched Successfully",userResponse,new Date()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody @Valid UserRequest userRequest, BindingResult result)
    {
        UserResponse userResponse = userService.create(userRequest,result);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(201,"User Created Successfully",userResponse,new Date()));
    }
}
