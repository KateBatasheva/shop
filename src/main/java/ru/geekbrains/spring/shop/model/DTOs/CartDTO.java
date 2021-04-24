package ru.geekbrains.spring.shop.model.DTOs;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring.shop.model.Cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CartDTO {

    private String name;
    private List<OrderProductDTO> products;
    private int totalPrice;

    public CartDTO(Cart cart) {
        this.name = cart.getName();
        if(cart.getProducts().size() == 0){
            this.products = new ArrayList<>();
            this.totalPrice = 0;
        }
        this.products = cart.getProducts().stream().map(OrderProductDTO::new).collect(Collectors.toList());
//        this.totalPrice = cart.getTotalCartPrice();
        cart.getProducts().stream().forEach(product -> {
            this.totalPrice += product.getTotalPrice();
        });
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
