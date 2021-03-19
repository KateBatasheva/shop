package ru.geekbrains.spring.shop.model.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.geekbrains.spring.shop.model.entities.Product;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String title;
    private int price;
    private String category;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getTitle();
    }

    public ProductDTO(Sort.Order order) {
    }
}
