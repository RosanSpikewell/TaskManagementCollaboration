package com.rosan.Task.Management.and.Collaboration.services;

import com.rosan.Task.Management.and.Collaboration.data.dtos.*;
import com.rosan.Task.Management.and.Collaboration.data.entities.Project;
import com.rosan.Task.Management.and.Collaboration.data.entities.User;
import com.rosan.Task.Management.and.Collaboration.data.repositories.ProjectRepositroy;
import com.rosan.Task.Management.and.Collaboration.data.repositories.UserRepository;
import com.rosan.Task.Management.and.Collaboration.exceptions.*;
import com.rosan.Task.Management.and.Collaboration.utils.EncryptionUtils;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepositroy projectRepositroy;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EncryptionUtils encrypt;


    @Override
    public List<UserResponse> getAll() {
        try {
            List<User> users = userRepository.findByIsActive(true);
            return users
                    .stream()
                    .map(user -> modelMapper.map(user, UserResponse.class)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new DataRetrievalFailureException("Unable to fetch data.");
        }
    }

    @Override
    public UserResponse getSingle(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found !!"));
        if (user.getActive())
            return modelMapper.map(user, UserResponse.class);
        else
            return null;
    }

    @Override
    public UserResponse create(UserRequest userRequest, BindingResult result) {
        if (userRepository.findByEmail(userRequest.getEmail()) != null)
            throw new EmailAlreadyExist("Email Already Exist");
        if (result.hasErrors())
            throw new AllFieldsRequiered("Please Enter all Fields");
        try {
            User user = modelMapper.map(userRequest, User.class);
            user.setId(UUID.randomUUID().toString());
            user.setRoles(userRequest.getRoles().toUpperCase().trim());
            user.setPassword(encrypt.passwordEncoder(userRequest.getPassword()));
            user.setCreatedat(new Date());
            user.setUpdatedat(new Date());
            userRepository.save(user);
            return modelMapper.map(user, UserResponse.class);
        } catch (ErrorWhileCreatingEntity ex) {
            throw new ErrorWhileCreatingEntity("Error While Saving the User!!" + ex.getMessage());
        } catch (Exception ex) {
            throw new ErrorWhileCreatingEntity("An unexpected error occurred during user creation." + ex.getMessage());
        }
    }

    @Override
    public UserResponse update(UserUpdateRequest userRequest, String id, BindingResult result) {
        if (id.isBlank())
            throw new AllFieldsRequiered("Id is Required");
        if (result.hasErrors())
            throw new AllFieldsRequiered("Requied Fields are missing or Error While Validating the Data");
        try {
            User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User Not Found."));
            user.setFirstname(userRequest.getFirstname());
            user.setMiddlename(userRequest.getMiddlename());
            user.setLastname(userRequest.getLastname());
            user.setEmail(userRequest.getEmail());
            user.setUpdatedat(new Date());
            userRepository.save(user);
            return modelMapper.map(user, UserResponse.class);
        } catch (ErrorWhileCreatingEntity ex) {
            throw new ErrorWhileCreatingEntity("Error Occured While Updating!!");
        }
    }

    @Override
    public UserResponse delete(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found."));
        if (!user.getActive())
            throw new NotFoundException("User Not Found.");
        try {
            user.setActive(false);
            userRepository.save(user);
            return modelMapper.map(user, UserResponse.class);
        } catch (ErrorWhileCreatingEntity ex) {
            throw new ErrorWhileCreatingEntity("Unable to Delete User!!");
        }
    }

    @Override
    public void updatePassword(ChangePasswordDto passwordDto, String id, BindingResult result) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User Not Found."));
        if (result.hasErrors())
            throw new AllFieldsRequiered("All Filed are Required!!!");
        if (!user.getActive())
            throw new NotFoundException("User not Found");
        if (!(passwordDto.getNewpassword().equals(passwordDto.getConfirmpassword())))
            throw new PasswordMismatchException("Password doesnt match.");
        try {
            user.setPassword(encrypt.passwordEncoder(passwordDto.getConfirmpassword()));
            user.setUpdatedat(new Date());
            userRepository.save(user);
        } catch (ErrorWhileCreatingEntity ex) {
            throw new ErrorWhileCreatingEntity("Error Occured while Updating the password.");
        }
    }

    @Override
    public void assignProject(String userid, String projectid) {
        User user = userRepository.findById(userid).orElseThrow(()->new NotFoundException("User not Found"));
        if(!user.getActive()){
            throw new NotFoundException("User not Found");
        }
        Project project = projectRepositroy.findById(projectid).orElseThrow(()->new NotFoundException("Project not Found"));
        user.setProject(project);
        try{
            userRepository.save(user);
        }catch (ErrorWhileCreatingEntity ex)
        {
            throw new ErrorWhileCreatingEntity("Error Occurred while saving the user");
        }
    }
}
