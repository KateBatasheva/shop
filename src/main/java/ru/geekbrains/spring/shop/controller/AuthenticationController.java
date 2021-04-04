package ru.geekbrains.spring.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.shop.model.DTOs.AuthRequestDto;
import ru.geekbrains.spring.shop.model.DTOs.AuthResponseDto;
import ru.geekbrains.spring.shop.model.DTOs.SignUpRequestDto;
import ru.geekbrains.spring.shop.model.entities.User;
import ru.geekbrains.spring.shop.security.JwtProvider;
import ru.geekbrains.spring.shop.services.UserService;

@RestController
public class AuthenticationController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody SignUpRequestDto signUpRequest) {
        User user = new User();
        user.setPassword(signUpRequest.getPassword());
        user.setLogin(signUpRequest.getLogin());
        userService.saveUser(user);
        return "OK";
    }

    @PostMapping("/auth")
    public AuthResponseDto auth(@RequestBody AuthRequestDto request) {
        User user = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(user.getLogin());
        return new AuthResponseDto(token);
    }

}
