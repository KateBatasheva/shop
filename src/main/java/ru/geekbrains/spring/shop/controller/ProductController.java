package ru.geekbrains.spring.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.shop.model.DTOs.CartDTO;
import ru.geekbrains.spring.shop.model.DTOs.ProductDTO;
import ru.geekbrains.spring.shop.model.entities.Product;
import ru.geekbrains.spring.shop.repository.Specification.ProductSpecification;
import ru.geekbrains.spring.shop.services.CartService;
import ru.geekbrains.spring.shop.services.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping
    public Page<ProductDTO> findAllProducts(
            @RequestParam MultiValueMap<String, String> params,
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(required = false) String direction,
            @RequestParam(required = false) String sort) {
        if (page < 1) {
            page = 1;
        }
        return productService.getAll(ProductSpecification.build(params), page, 4, direction, sort);
    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getById(id).get();
    }


    @PostMapping
    public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }


    @PutMapping("/{id}")
    public Product put(@RequestBody ProductDTO product) {
        Product pr = productService.getFullProduct(product.getId());
        pr.setPrice(product.getPrice());
        pr.setTitle(product.getTitle());
        pr.setCategory(productService.findCategoryByName(product.getCategory()));
        return pr;
    }

    @GetMapping("/cart")
    public CartDTO showCart() {
        return cartService.showCart();
    }
//
//    @GetMapping ("/cart")
//    public Page<CartDTO> showCart (@RequestParam CartDTO cartDTO){
//        return cartService.showCart();
//    }

}
