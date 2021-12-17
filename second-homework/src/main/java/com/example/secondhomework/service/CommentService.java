package com.example.secondhomework.service;

import com.example.secondhomework.dao.CommentDAO;
import com.example.secondhomework.entity.ProductComment;
import com.example.secondhomework.entity.User;
import com.example.secondhomework.exception.ProductCommentIsNotException;
import com.example.secondhomework.exception.ProductIsNotException;
import com.example.secondhomework.exception.UserIsNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {

    private final CommentDAO commentDAO;

    public List<ProductComment> findByUserId(Long userId)
    {
        Boolean isExist = commentDAO.existsById(userId);
        if(!isExist)
        {
            throw new UserIsNotExistException(userId + " id number user didnt write comment");
        }
        return commentDAO.findAllByUserId(userId);
    }

    public List<ProductComment> findByProductId(Long productId)
    {
        Boolean isExist = commentDAO.existsById(productId);
        if(!isExist)
        {
            throw new ProductIsNotException("The comment was not written belong to " + productId + " id number product ");
        }
        return commentDAO.findAllByProductId(productId);
    }

    public ProductComment save(ProductComment productComment) {
        return commentDAO.save(productComment);
    }

    public ProductComment findById(Long id){
        var comment = commentDAO.findById(id).orElse(null);
        if(Objects.isNull(comment))
        {
            throw new ProductCommentIsNotException("The comment "+ id + " id number is not found");
        }
        return comment;
    }
    public void deleteById(Long commentId)
    {
        commentDAO.deleteById(commentId);
    }

}
