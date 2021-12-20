package com.example.secondhomework.dao;

import com.example.secondhomework.entity.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCommentDAO extends JpaRepository<ProductComment, Long> {
    //@Query("select product_comment from ProductComment product_comment where product_comment.user.id = :userId")
    List<ProductComment> findAllByUserId(Long userId);
    Boolean existsByUserId(Long userId);
    List<ProductComment> findAllByProductId(Long productId);
    Boolean existsByProductId(Long productId);
}
