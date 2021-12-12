package com.example.secondhomework.service;

import com.example.secondhomework.dao.UserDAO;
import com.example.secondhomework.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> findAll(){
        return userDAO.findAll();
    }


}
