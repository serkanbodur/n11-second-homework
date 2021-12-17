package com.example.secondhomework.dto;

import lombok.*;

import javax.persistence.*;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String username;
}
