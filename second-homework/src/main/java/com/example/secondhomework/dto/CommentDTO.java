package com.example.secondhomework.dto;

import com.example.secondhomework.entity.Product;
import com.example.secondhomework.entity.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class CommentDTO {
    private Long id;
    private String comment;
    private Date commentDate;
    private Long productId;
    private Long userId;
}
