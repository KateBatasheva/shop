package ru.geekbrains.spring.shop.model.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.spring.shop.model.entities.Category;

@Data
@NoArgsConstructor
public class CategoryDTO {
    private Long id;
    private String title;

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
    }
}
