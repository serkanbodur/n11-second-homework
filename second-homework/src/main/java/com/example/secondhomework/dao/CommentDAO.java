package com.example.secondhomework.dao;

import com.example.secondhomework.entity.ProductComment;
import com.example.secondhomework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentDAO extends JpaRepository<ProductComment, Long> {
    @Query("select product_comment from ProductComment product_comment where product_comment.user.id = :userId")
    List<ProductComment> findAllByUserId(Long userId);

}
