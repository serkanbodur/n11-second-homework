package com.example.secondhomework.controller;

import com.example.secondhomework.converter.CommentConverter;
import com.example.secondhomework.dto.CommentDTO;
import com.example.secondhomework.entity.ProductComment;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.exception.ProductCommentIsNotException;
import com.example.secondhomework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments/")
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<CommentDTO>> productCommentsByUserId (@PathVariable Long userId) {

        List<ProductComment> productComments = commentService.findByUserId(userId);
        List<CommentDTO> commentDTOs = CommentConverter.INSTANCE.convertProductCommentsToCommentDTOs(productComments);
        return new ResponseEntity<>(commentDTOs, HttpStatus.OK);

    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<List<CommentDTO>> productCommentByProductId(@PathVariable Long productId)
    {
        List<ProductComment> productComments = commentService.findByProductId(productId);
        List<CommentDTO> commentDTOs = CommentConverter.INSTANCE.convertProductCommentsToCommentDTOs(productComments);
        return new ResponseEntity<>(commentDTOs,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<CommentDTO> saveComment(@RequestBody CommentDTO commentDTO)
    {
        var comment = CommentConverter.INSTANCE.convertCommentDTOToProductComment(commentDTO);
        comment = commentService.save(comment);
        var responseCommentDTO = CommentConverter.INSTANCE.convertProductCommentToCommentDTO(comment);
        return new ResponseEntity<>(responseCommentDTO,HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable Long id)
    {
        var comment = commentService.findById(id);
        var commentDTO = CommentConverter.INSTANCE.convertProductCommentToCommentDTO(comment);
        commentService.deleteById(commentDTO.getId());
    }

}
