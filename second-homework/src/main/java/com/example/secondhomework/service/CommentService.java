package com.example.secondhomework.service;

import com.example.secondhomework.dao.CommentDAO;
import com.example.secondhomework.entity.ProductComment;
import com.example.secondhomework.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentDAO commentDAO;

    public List<ProductComment> findByUser(Long userId)
    {
        return commentDAO.findAllByUserId(userId);
    }
}
