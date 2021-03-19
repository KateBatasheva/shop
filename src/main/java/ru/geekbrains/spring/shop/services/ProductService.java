package ru.geekbrains.spring.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.shop.model.DTOs.ProductDTO;
import ru.geekbrains.spring.shop.model.entities.Category;
import ru.geekbrains.spring.shop.model.entities.Product;
import ru.geekbrains.spring.shop.repository.CategoryRepository;
import ru.geekbrains.spring.shop.repository.ProductRepository;

import java.util.List;
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

    public Page<ProductDTO> getAll(Integer page, Integer size, String direction, String sort) {
        if (!sort.equals("price") && !sort.equals("title") && !sort.isEmpty()){
            sort = "price";
        }
        if (productRepository.findAll().size() > size * page) {
            if (direction == null || direction.equals(DirectionSorting.ABS.name()) || direction.isEmpty()) {
//                return productRepository.findAll(PageRequest.of(page, size), Sort.by(sort)).map(ProductDTO::new);
                return (Page<ProductDTO>) productRepository.findAll(PageRequest.of(page, size)).map(ProductDTO::new);
            } else {
//                return productRepository.findAll(PageRequest.of(page, size), Sort.by(sort).descending()).map(ProductDTO::new);
                return (Page<ProductDTO>) productRepository.findAll(PageRequest.of(page, size)).map(ProductDTO::new);
//                return productRepository.findAll(PageRequest.of(page, size).getSort().and(Sort.by(sort).descending()));
            }
        } else {
            int lastPage = 0;
            if (productRepository.findAll().size() % size == 0) {
                lastPage = productRepository.findAll().size() / size;
            } else {
                lastPage = productRepository.findAll().size() / size + 1;
            }
            if (direction.equals(DirectionSorting.ABS.name()) || direction.isEmpty()) {
//                return productRepository.findAll(PageRequest.of(lastPage, size).getSort().and(Sort.by(sort)));
                return (Page<ProductDTO>) productRepository.findAll(PageRequest.of(lastPage, size)).map(ProductDTO::new);
//                return productRepository.findAll(PageRequest.of(lastPage, size), Sort.by(sort)).map(ProductDTO::new);
            } else {
//                return productRepository.findAll(PageRequest.of(lastPage, size).getSort().and(Sort.by(sort).descending()));
                return (Page<ProductDTO>) productRepository.findAll(PageRequest.of(lastPage, size)).map(ProductDTO::new);
//                return productRepository.findAll(PageRequest.of(lastPage, size), Sort.by(sort).descending()).map(ProductDTO::new);
            }
        }
    }
//
//    public Page<ProductDTO> getAll() {
//        return productRepository.findAll().stream().map(ProductDTO::new).map();
//    }

    public Optional<ProductDTO> getById(Long id) {
        return productRepository.findById(id).map(ProductDTO::new);
    }

    public Product getFullProduct (Long id){
        return productRepository.findById(id).get();
    }

    public ProductDTO getByName(String title) {
        ProductDTO pr = new ProductDTO(productRepository.findProductByTitle(title));
        return pr;
    }


    public Category findCategoryByName (String name){
        return categoryRepository.findCategoryByTitle(name);
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
