package com.example.secondhomework.controller;

import com.example.secondhomework.entity.ProductComment;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{userId}")
    public List<ProductComment> productComments (@PathVariable Long userId){return commentService.findByUser(userId);}

}
