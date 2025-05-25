package com.example.customAnotation.controller;

import com.example.customAnotation.annotation.PreventDuplicate;
import com.example.customAnotation.dto.UserDTO;
import com.example.customAnotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("/names")
    @PreventDuplicate
    public Object getNames() {
        return Arrays.asList("Alice", "Bob", "Alice");
    }

}
