package com.example.secondhomework.controller;

import com.example.secondhomework.converter.UserConverter;
import com.example.secondhomework.dto.UserDTO;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/users/")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("")
    public List<UserDTO> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOs = UserConverter.INSTANCE.convertAllUsersToUserDTOs(users);
        return userDTOs;
    }

    @GetMapping("/username/{username}")
    public UserDTO findByUsername(@PathVariable String username) {

        var user = userService.findByUsername(username);
        return UserConverter.INSTANCE.convertUserToUserDTOs(user);
    }

    @GetMapping("/phone/{phone}")
    public UserDTO findByPhone(@PathVariable String phone) {
        var user = userService.findByPhone(phone);
        return UserConverter.INSTANCE.convertUserToUserDTOs(user);
    }

    @PostMapping()
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        return userService.update(user);
    }

}
