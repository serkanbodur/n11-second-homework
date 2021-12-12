package com.example.secondhomework.dao;

import com.example.secondhomework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
