package com.example.secondhomework.controller;

import com.example.secondhomework.converter.UserConverter;
import com.example.secondhomework.dto.UserDTO;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.apache.logging.log4j.message.Message;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users/")
public class UserController {

    private final UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        var userDTOs = userService.findAll();
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/username/{username}")
    public ResponseEntity<UserDTO> findByUsername(@RequestParam String username) {
        var userDTO = userService.findByUsername(username);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @RequestMapping(value = "/phone/{phone}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findByPhone(@RequestParam String phone) {
        var userDTO = userService.findByPhone(phone);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        var responseUserDTO = userService.save(userDTO);
        return new ResponseEntity<>(responseUserDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{username}/{phone}", method = RequestMethod.DELETE)
    public ResponseEntity<UserDTO> deleteUser(@RequestParam("username") String username, @RequestParam("phone") String phone) {
        var deletedUser = userService.deleteByUsernameAndPhone(username,phone);
        return new ResponseEntity<>(deletedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        var updateUserDTO = userService.update(userDTO,id);
        return new ResponseEntity<>(updateUserDTO,HttpStatus.OK);
    }

}
