package com.example.secondhomework.controller;

import com.example.secondhomework.converter.CommentConverter;
import com.example.secondhomework.dto.CommentDTO;
import com.example.secondhomework.entity.ProductComment;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.exception.ProductCommentIsNotException;
import com.example.secondhomework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments/")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/users/{userId}")
    public List<CommentDTO> productCommentsByUserId (@PathVariable Long userId) {

        List<ProductComment> productComments = commentService.findByUserId(userId);
        List<CommentDTO> commentDTOs = CommentConverter.INSTANCE.convertProductCommentsToCommentDTOs(productComments);
        return commentDTOs;

    }

    @GetMapping("/products/{productId}")
    public List<CommentDTO> productCommentByProductId(@PathVariable Long productId)
    {
        List<ProductComment> productComments = commentService.findByProductId(productId);
        List<CommentDTO> commentDTOs = CommentConverter.INSTANCE.convertProductCommentsToCommentDTOs(productComments);
        return  commentDTOs;
    }

    @PostMapping()
    public CommentDTO saveComment(@RequestBody CommentDTO commentDTO)
    {
        var comment = CommentConverter.INSTANCE.convertCommentDTOToProductComment(commentDTO);
        comment = commentService.save(comment);
        return CommentConverter.INSTANCE.convertProductCommentToCommentDTO(comment);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable Long id)
    {
        var comment = commentService.findById(id);
        var commentDTO = CommentConverter.INSTANCE.convertProductCommentToCommentDTO(comment);
        commentService.deleteById(commentDTO.getId());
    }

}
