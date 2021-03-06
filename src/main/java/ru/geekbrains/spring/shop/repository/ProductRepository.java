package ru.geekbrains.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.shop.model.Product;

import javax.persistence.NamedNativeQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(String title);
    List<Product> findProductByPriceBetween (Integer first, Integer second);
    List<Product> findProductByPriceLessThanEqual (Integer price);
    List<Product> findProductByPriceGreaterThanEqual (Integer price);
    List<Product> findByTitleLike (String title);

}
