package ru.geekbrains.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.spring.shop.model.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByTitle (String title);
}
