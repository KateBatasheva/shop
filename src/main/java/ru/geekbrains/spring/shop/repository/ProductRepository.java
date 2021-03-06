package ru.geekbrains.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.shop.model.Product;

import javax.persistence.NamedNativeQuery;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductById(String title);

//    @Query("select * from products;")
//    List<Product> customProductsQuery(int id);
}
