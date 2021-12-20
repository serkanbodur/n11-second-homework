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
        List<User> users = userService.findAll();
        List<UserDTO> userDTOs = UserConverter.INSTANCE.convertAllUsersToUserDTOs(users);
        return new ResponseEntity<>(userDTOs, HttpStatus.OK);
    }

    // TODO check the same url path seperate different params
    @RequestMapping(params="username", value = "/", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findByUsername(@RequestParam("username") String username) {

        var user = userService.findByUsername(username);
        var userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @RequestMapping(params="phone", value = "/", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findByPhone(@RequestParam("phone") String phone) {
        var user = userService.findByPhone(phone);
        var userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        var user = UserConverter.INSTANCE.convertUserDTOToUser(userDTO);
        user = userService.save(user);
        userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        return new ResponseEntity<>(userDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "{username}/{phone}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam("username") String username, @RequestParam("phone") String phone) {
        var user = userService.findByUsernameAndPhone(username, phone);
        var userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        userService.deleteByUsernameAndPhone(userDTO.getUsername(),userDTO.getPhone());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO userDTO) {

        return new ResponseEntity<>(userService.update(userDTO,id),HttpStatus.OK);
    }

}
