package com.example.secondhomework.service;

import com.example.secondhomework.converter.ProductCommentConverter;
import com.example.secondhomework.dao.ProductCommentDAO;
import com.example.secondhomework.dto.ProductCommentDTO;
import com.example.secondhomework.entity.ProductComment;
import com.example.secondhomework.exception.ProductCommentIsNotExistException;
import com.example.secondhomework.exception.ProductIsNotExistException;
import com.example.secondhomework.exception.UserIsNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCommentService {

    private final ProductCommentDAO productCommentDAO;

    public List<ProductCommentDTO> findByUserId(Long userId) {
        Boolean isExist = productCommentDAO.existsByUserId(userId);
        if(!isExist) {
            throw new UserIsNotExistException(userId + " id number user didnt write comment");
        }

        List<ProductComment> productComments = productCommentDAO.findAllByUserId(userId);
        List<ProductCommentDTO> productCommentDTOS = ProductCommentConverter.INSTANCE.convertProductCommentsToCommentDTOs(productComments);
        return productCommentDTOS;
    }

    public List<ProductCommentDTO> findByProductId(Long productId) {
        Boolean isExist = productCommentDAO.existsByProductId(productId);
        if(!isExist) {
            throw new ProductIsNotExistException("The comment was not written belong to " + productId + " id number product ");
        }

        List<ProductComment> productComments = productCommentDAO.findAllByProductId(productId);
        List<ProductCommentDTO> productCommentDTOs = ProductCommentConverter.INSTANCE.convertProductCommentsToCommentDTOs(productComments);
        return productCommentDTOs;
    }

    public ProductCommentDTO save(ProductCommentDTO productCommentDTO) {
        var comment = ProductCommentConverter.INSTANCE.convertCommentDTOToProductComment(productCommentDTO);
        comment = productCommentDAO.save(comment);
        productCommentDTO = ProductCommentConverter.INSTANCE.convertProductCommentToCommentDTO(comment);
        return productCommentDTO;
    }

    public ProductCommentDTO deleteById(Long id){
        var comment = productCommentDAO.existsById(id);
        if(!comment) {
            throw new ProductCommentIsNotExistException("The comment "+ id + " id number is not found");
        }

        var productComment = productCommentDAO.findById(id).orElse(null);
        var commentDTO = ProductCommentConverter.INSTANCE.convertProductCommentToCommentDTO(productComment);
        productCommentDAO.deleteById(id);
        return commentDTO;
    }
}
