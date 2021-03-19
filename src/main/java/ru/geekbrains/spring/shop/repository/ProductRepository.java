package ru.geekbrains.spring.shop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.shop.model.entities.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(String title);
    List<Product> findProductByPriceBetween (Integer first, Integer second);
    List<Product> findProductByPriceLessThanEqual (Integer price);
    List<Product> findProductByPriceGreaterThanEqual (Integer price);
    List<Product> findByTitleLike (String title);

//    Page<Product> findAll(Pageable pageable, Sort sort);
//    Page<Product> findAll(Pageable pageable, Sort sort);
}
