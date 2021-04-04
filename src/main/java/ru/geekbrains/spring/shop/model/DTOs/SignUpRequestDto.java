package ru.geekbrains.spring.shop.model.DTOs;

import lombok.Data;

@Data
public class SignUpRequestDto {

    private String login;

    private String password;
}