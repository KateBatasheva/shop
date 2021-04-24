package ru.geekbrains.spring.shop.model.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.geekbrains.spring.shop.model.entities.OrderProduct;
import ru.geekbrains.spring.shop.model.entities.Product;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String title;
    private Integer price;
    private String category;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getTitle();
    }

    public ProductDTO(Sort.Order order) {
    }

    public ProductDTO(OrderProduct orderProduct) {
    }
}
