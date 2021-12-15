package com.example.secondhomework.service;

import com.example.secondhomework.dao.UserDAO;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.exception.UserIsNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public User findByUsername(String username) {
        Boolean isExist = userDAO.existsUserByUsername(username);

        if (!isExist) {
            throw new UserIsNotExistException("User with username : " + username + " is not exists!");
        }
        return userDAO.findUserByUsername(username);
    }

    public User findByPhone(String phone) {
        Boolean isExist = userDAO.existsUserByPhone(phone);
        if (!isExist) {
            throw new UserIsNotExistException("User with phone : " + phone + " is not exists!");
        }
        return userDAO.findUserByPhone(phone);
    }

    public User save(User user) {
        return userDAO.save(user);
    }

    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }

    public User findById(Long id) {
        return userDAO.findById(id).orElse(null);
    }

    public User update(User user) {
        var updatedUser = new User();
        updatedUser.setId(user.getId());
        updatedUser.setUsername(user.getUsername());
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setPhone(user.getPhone());
        updatedUser.setEmail(user.getEmail());

        return userDAO.save(updatedUser);
    }

}
