package ru.geekbrains.spring.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"ru.geekbrains.spring.shop"})
@SpringBootApplication
public class ShopApp {

    public static void main(String[] args) {
        SpringApplication.run(ShopApp.class, args);
    }

}
