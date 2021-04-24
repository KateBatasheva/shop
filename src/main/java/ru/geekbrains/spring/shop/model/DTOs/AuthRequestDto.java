package ru.geekbrains.spring.shop.model.DTOs;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String login;
    private String password;
}