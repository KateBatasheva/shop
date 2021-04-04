package ru.geekbrains.spring.shop.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.shop.model.entities.OrderProduct;
import ru.geekbrains.spring.shop.services.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
@Component
public class Cart {
    private String name;
    private List<OrderProduct> products;
    private int totalCartPrice;

//    @Autowired
//    private ProductService productService;

    private static Cart INSTANCE = new Cart();
    private Random random = new Random();

    private Cart(){
        this.name = (char) (random.nextInt() * 100) + "";
        this.products = new ArrayList<>();
        this.totalCartPrice = 0;
    }

    public static Cart getCart (){
        if (INSTANCE == null){
            return new Cart();
        }
        return INSTANCE;
    }

}
