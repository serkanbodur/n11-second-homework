package com.example.secondhomework.controller;

import com.example.secondhomework.converter.UserConverter;
import com.example.secondhomework.dto.UserDTO;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users/")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<UserDTO> findAll() {
        List<User> users = userService.findAll();
        List<UserDTO> userDTOs = UserConverter.INSTANCE.convertAllUsersToUserDTOs(users);
        return userDTOs;
    }

    @GetMapping("/username/{username}")
    public UserDTO findByUsername(@PathVariable String username) {

        var user = userService.findByUsername(username);
        return UserConverter.INSTANCE.convertUserToUserDTO(user);
    }

    @GetMapping("/phone/{phone}")
    public UserDTO findByPhone(@PathVariable String phone) {
        var user = userService.findByPhone(phone);
        return UserConverter.INSTANCE.convertUserToUserDTO(user);
    }

    @PostMapping()
    public UserDTO saveUser(@RequestBody UserDTO userDTO) {
        var user = UserConverter.INSTANCE.convertUserDTOToUser(userDTO);
        user = userService.save(user);
        return UserConverter.INSTANCE.convertUserToUserDTO(user);
    }

    @DeleteMapping("{username}/{phone}")
    public void deleteUser(@PathVariable String username, @PathVariable String phone) {
        var user = userService.findByUsernameAndPhone(username, phone);
        var userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        userService.deleteByUsernameAndPhone(userDTO.getUsername(),userDTO.getPhone());
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id);
        return userService.update(userDTO);
    }

}
