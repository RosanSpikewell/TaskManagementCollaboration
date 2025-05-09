package com.rosan.Task.Management.and.Collaboration.services;

import com.rosan.Task.Management.and.Collaboration.data.entities.User;
import com.rosan.Task.Management.and.Collaboration.data.entities.UserRequest;
import com.rosan.Task.Management.and.Collaboration.data.entities.UserResponse;
import com.rosan.Task.Management.and.Collaboration.data.repositories.UserRepository;
import com.rosan.Task.Management.and.Collaboration.exceptions.AllFieldsRequiered;
import com.rosan.Task.Management.and.Collaboration.exceptions.EmailAlreadyExist;
import com.rosan.Task.Management.and.Collaboration.exceptions.ErrorWhileCreatingEntity;
import com.rosan.Task.Management.and.Collaboration.exceptions.NotFoundException;
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
    private ModelMapper modelMapper;

    @Autowired
    private EncryptionUtils encrypt;


    @Override
    public List<UserResponse> getAll() {
        try {
            List<User> users = userRepository.findAll();
            return users
                    .stream()
                    .map(user -> modelMapper.map(user, UserResponse.class)).collect(Collectors.toList());
        } catch (Exception e) {
               throw new DataRetrievalFailureException("Unable to fetch data.");
        }
    }

    @Override
    public UserResponse getSingle(String id) {
       User user = userRepository.findById(id).orElseThrow(()->new NotFoundException("User Not Found !!"));
       return modelMapper.map(user,UserResponse.class);
    }

    @Override
    public UserResponse create(UserRequest userRequest, BindingResult result) {
            if(userRepository.findByEmail(userRequest.getEmail()) != null)
                throw new EmailAlreadyExist("Email Already Exist");
            if(result.hasErrors())
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
        }
        catch (ErrorWhileCreatingEntity ex) {
            throw new ErrorWhileCreatingEntity("Error While Saving the User!!" + ex.getMessage());
        }catch (Exception ex){
            throw new ErrorWhileCreatingEntity("An unexpected error occurred during user creation." + ex.getMessage());
        }
    }
    @Override
    public UserResponse update(UserRequest userRequest, String id) {
        return null;
    }

    @Override
    public UserResponse delete(String id) {
        return null;
    }

}
