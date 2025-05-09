package com.rosan.Task.Management.and.Collaboration.controllers;

import com.rosan.Task.Management.and.Collaboration.data.dtos.*;
import com.rosan.Task.Management.and.Collaboration.exceptions.AllFieldsRequiered;
import com.rosan.Task.Management.and.Collaboration.services.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<UserResponse>>> getAllUser() {
        List<UserResponse> users = userService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ApiResponse<>(200, "User Details Fetched Successfully", users, new Date()));
    }

    @GetMapping("/{userid}")
    public ResponseEntity<ApiResponse<?>> getSingleUser(@PathVariable String userid) {
        UserResponse userResponse = userService.getSingle(userid);
        if (userResponse != null)
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200, "User Fetched Successfully", userResponse, new Date()));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(404, "User Not Found", new Empty(), new Date()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody @Valid UserRequest userRequest, BindingResult result) {
        UserResponse userResponse = userService.create(userRequest, result);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(201, "User Created Successfully", userResponse, new Date()));
    }

    @PutMapping("/{userid}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUser(@RequestBody @Valid UserUpdateRequest userUpdateRequest, @PathVariable String userid, BindingResult result) {
        UserResponse userResponse = userService.update(userUpdateRequest, userid, result);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200, "User Updated Successfullt.", userResponse, new Date()));
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<ApiResponse<UserResponse>> deleteUser(@PathVariable String userid) {
        UserResponse userResponse = userService.delete(userid);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200, "User Deleted Successfully", userResponse, new Date()));
    }

    @PatchMapping("/{userid}/password")
    public ResponseEntity<ApiResponse<?>> updatePassword( @RequestBody @Valid ChangePasswordDto passwordDto , @PathVariable String userid,BindingResult result){
        System.out.println(result);
        userService.updatePassword(passwordDto,userid,result);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(200,"Password Changed",new Empty(),new Date()));
    }

}
