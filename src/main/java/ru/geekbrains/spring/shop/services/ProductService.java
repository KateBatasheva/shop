package ru.geekbrains.spring.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.shop.model.DTOs.ProductDTO;
import ru.geekbrains.spring.shop.model.entities.Category;
import ru.geekbrains.spring.shop.model.entities.Product;
import ru.geekbrains.spring.shop.repository.CategoryRepository;
import ru.geekbrains.spring.shop.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductDTO> getAll(Specification<Product> spec, int page, int size, String direction, String sort) {
        if (sort == null) {
            sort = Sorting.PRICE.name().toLowerCase();
        }
        if (direction == null) {
            direction = DirectionSorting.ABS.name();
        } else if (direction.equals(DirectionSorting.DESC.name().toLowerCase())) {
            return productRepository.findAll(spec, PageRequest.of(page - 1, 4, Sort.by(sort).descending())).map(ProductDTO::new);
        }
        return productRepository.findAll(spec, PageRequest.of(page - 1, 4, Sort.by(sort))).map(ProductDTO::new);
    }


    public Optional<ProductDTO> getById(Long id) {
        return productRepository.findById(id).map(ProductDTO::new);
    }

    public Optional<Product> getByIdProduct(Long id) {
        return productRepository.findById(id);
    }

    public Product getFullProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public Optional<ProductDTO> getByName(String title) {
        return productRepository.findProductByTitle(title).map(ProductDTO::new);
    }


    public Category findCategoryByName(String name) {
        return categoryRepository.findCategoryByTitle(name);
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void delete(String title) {
        productRepository.deleteById(productRepository.findProductByTitle(title).get().getId());
    }

}
