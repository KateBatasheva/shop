package ru.geekbrains.spring.shop.model.DTOs;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring.shop.model.entities.Cart;
import ru.geekbrains.spring.shop.model.entities.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CartDTO {

    private String name;
    private List<ProductDTO> products;

    public CartDTO(Cart cart) {
        this.name = cart.getName();
        if(cart.getProducts().size() == 0){
            this.products = new ArrayList<>();
        }
        this.products = cart.getProducts().stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
