package com.example.secondhomework.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductCommentDTO {
    private Long id;
    private String comment;
    private Date commentDate;
    private Long productId;
    private String productName;
    private Long userId;
    private String userName;
}
