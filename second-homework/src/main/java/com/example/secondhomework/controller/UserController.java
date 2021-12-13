package com.example.secondhomework.controller;

import com.example.secondhomework.entity.User;
import com.example.secondhomework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/username/{username}")
    public User findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/phone/{phone}")
    public User findByPhone(@PathVariable String phone)
    {
        return userService.findByPhone(phone);
    }

}
