package ru.geekbrains.spring.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.shop.model.Product;
import ru.geekbrains.spring.shop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }

    public Product getByName(String title) {
        return productRepository.findProductById(title);
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductByPrice(Integer first, Integer second){
        return productRepository.findProductByPriceBetween(first,second);
    }

    public List<Product> getProdusctByTitle (String title){
        return productRepository.findByTitleLike(title);
    }

    public List<Product> getProductByMinPrice (Integer price){
        return productRepository.findProductByPriceGreaterThanEqual(price);
    }
    public List<Product> getProductByMaxPrice (Integer price){
        return productRepository.findProductByPriceLessThanEqual(price);
    }

}
