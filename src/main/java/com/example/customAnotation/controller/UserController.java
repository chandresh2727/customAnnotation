package com.example.customAnotation.controller;

import com.example.customAnotation.dto.UserDTO;
import com.example.customAnotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDTO register(@RequestBody UserDTO user) {
//        userService.registerUser(user);
        return userService.registerUser(user);
    }

}
