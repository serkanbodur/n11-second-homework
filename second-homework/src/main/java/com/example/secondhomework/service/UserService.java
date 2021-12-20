package com.example.secondhomework.service;

import com.example.secondhomework.converter.UserConverter;
import com.example.secondhomework.dao.UserDAO;
import com.example.secondhomework.dto.UserDTO;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.exception.UserIsNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Transactional // For delete method
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDAO userDAO;

    public List<UserDTO> findAll() {
        List<User> users = userDAO.findAll();
        List<UserDTO> userDTOs = UserConverter.INSTANCE.convertAllUsersToUserDTOs(users);
        return userDTOs;
    }

    public UserDTO findByUsername(String username) {
        Boolean isExist = userDAO.existsByUsername(username);
        if (!isExist) {
            throw new UserIsNotExistException("User with username : " + username + " is not exists!");
        }

        var user = userDAO.findByUsername(username);
        var userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        return userDTO;
    }

    public UserDTO findByPhone(String phone) {
        Boolean isExist = userDAO.existsByPhone(phone);
        if (!isExist) {
            throw new UserIsNotExistException("User with phone : " + phone + " is not exists!");
        }

        var user = userDAO.findByPhone(phone);
        var userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        return userDTO;
    }

    public UserDTO save(UserDTO userDTO) {
        var user = UserConverter.INSTANCE.convertUserDTOToUser(userDTO);
        user = userDAO.save(user);
        userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        return userDTO;
    }

    // Transactional for delete method
    // First it finds the id which will be deleted as username and phone
    // Then make delete process
    // So there are two different queries, need a transactional annotation
    @Transactional
    public UserDTO deleteByUsernameAndPhone(String username, String phone) {
        Boolean isExists = userDAO.existsByUsernameAndPhone(username, phone);
        if(!isExists) {
            throw new UserIsNotExistException("User phone : " + phone + " and user username : " + username + " is not matching with each other!");
        }

        var user = userDAO.findByUsernameAndPhone(username, phone);
        userDAO.deleteByUsernameAndPhone(username, phone);
        var userDTO = UserConverter.INSTANCE.convertUserToUserDTO(user);
        return userDTO;
    }

    public UserDTO update(UserDTO userDTO,Long id) {
        var user = userDAO.findById(id).orElse(null);
        if(Objects.isNull(user)) {
            throw new UserIsNotExistException("User id : " + userDTO.getId() + " is not found!");
        }

        user.setId(id);
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setUsername(userDTO.getUsername());
        user = userDAO.save(user);
        userDTO =  UserConverter.INSTANCE.convertUserToUserDTO(user);
        return userDTO;
    }
}
