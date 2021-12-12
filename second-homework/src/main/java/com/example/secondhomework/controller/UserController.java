package com.example.secondhomework.controller;

import com.example.secondhomework.entity.User;
import com.example.secondhomework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    public List<User> findAll() {
        List<User> userList = userService.findAll();
        return userList;
    }
}
