package com.example.secondhomework.controller;

import com.example.secondhomework.converter.ProductCommentConverter;
import com.example.secondhomework.dto.ProductCommentDTO;
import com.example.secondhomework.entity.ProductComment;
import com.example.secondhomework.service.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comments/")
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<ProductCommentDTO>> productCommentsByUserId (@PathVariable Long userId) {
        var productCommentDTOS = productCommentService.findByUserId(userId);
        return new ResponseEntity<>(productCommentDTOS, HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<List<ProductCommentDTO>> productCommentByProductId(@PathVariable Long productId) {
        var productCommentDTOs = productCommentService.findByProductId(productId);
        return new ResponseEntity<>(productCommentDTOs,HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductCommentDTO> saveComment(@RequestBody ProductCommentDTO productCommentDTO) {
        var responseCommentDTO = productCommentService.save(productCommentDTO);
        return new ResponseEntity<>(responseCommentDTO,HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProductCommentDTO> deleteComment(@PathVariable Long id){
        var deletedComment = productCommentService.deleteById(id);
        return new ResponseEntity<>(deletedComment, HttpStatus.OK);
    }
}
