package com.example.secondhomework.dao;

import com.example.secondhomework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserDAO extends JpaRepository<User, Long> {

    User findByUsername(String username);
    Boolean existsByUsername(String username);
    User findByPhone(String phone);
    Boolean existsByPhone(String phone);
    Boolean existsByUsernameAndPhone(String username, String phone);
    User findByUsernameAndPhone(String username, String phone);

    void deleteByUsernameAndPhone(String username, String phone);
}
