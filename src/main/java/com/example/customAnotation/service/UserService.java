package com.example.customAnotation.service;

import com.example.customAnotation.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDTO registerUser(UserDTO user) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Encrypted Password: " + user.getPassword());
        return user;
    }
}
