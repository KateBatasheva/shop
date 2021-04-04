package ru.geekbrains.spring.shop.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "order_products")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "total_price")
    private int totalPrice;

    public OrderProduct(Product product) {
        this.product = product;
        this.quantity = 1;
        this.price = product.getPrice();
        this.totalPrice = this.price;
    }

    public void incrementQuantity() {
        quantity++;
        totalPrice = quantity * price;
    }

    public void decrementQuantity() {
        quantity--;
        totalPrice = quantity * price;
    }
}
