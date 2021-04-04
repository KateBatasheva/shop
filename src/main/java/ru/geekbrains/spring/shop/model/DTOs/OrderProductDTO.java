package ru.geekbrains.spring.shop.model.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring.shop.model.entities.OrderProduct;

@NoArgsConstructor
@Data
public class OrderProductDTO {
    private String productTitle;
    private int quantity;
    private int priceProduct;
    private int price;

    public OrderProductDTO(OrderProduct order) {
        this.productTitle = order.getProduct().getTitle();
        this.quantity = order.getQuantity();
        this.priceProduct = order.getPrice();
        this.price = order.getPrice();
    }
}
