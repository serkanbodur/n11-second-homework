package com.example.secondhomework.converter;

import com.example.secondhomework.dto.CommentDTO;
import com.example.secondhomework.entity.Product;
import com.example.secondhomework.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentConverter {

    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    List<CommentDTO> convertProductCommentsToCommentDTOs(List<ProductComment> productComments);


    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "productId", target = "product.id")
    ProductComment convertCommentDTOToProductComment(CommentDTO commentDTO);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    CommentDTO convertProductCommentToCommentDTO(ProductComment productComment);
}
