package com.example.secondhomework.converter;

import com.example.secondhomework.dto.ProductCommentDTO;
import com.example.secondhomework.entity.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentConverter {

    ProductCommentConverter INSTANCE = Mappers.getMapper(ProductCommentConverter.class);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "user.username", target = "userName")
    List<ProductCommentDTO> convertProductCommentsToCommentDTOs(List<ProductComment> productComments);


    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "productName", target = "product.name")
    @Mapping(source = "userName", target = "user.username")
    ProductComment convertCommentDTOToProductComment(ProductCommentDTO productCommentDTO);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "user.username", target = "userName")
    ProductCommentDTO convertProductCommentToCommentDTO(ProductComment productComment);
}
