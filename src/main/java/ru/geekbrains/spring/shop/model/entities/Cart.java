package ru.geekbrains.spring.shop.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
import java.util.Random;

@Data
public class Cart {
    private String name;
    private List<Product> products;

    private static Cart INSTANCE = new Cart();
    private Random random = new Random();

    public Cart(String name) {
        this.name = name;
    }

    private Cart(){
        this.name = (char) (random.nextInt() * 100) + "";
    }

    public static Cart getCart (){
        if (INSTANCE == null){
            return new Cart();
        }
        return INSTANCE;
    }

}
