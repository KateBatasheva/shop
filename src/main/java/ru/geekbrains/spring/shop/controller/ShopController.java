package ru.geekbrains.spring.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.shop.model.Product;
import ru.geekbrains.spring.shop.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ShopController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @GetMapping("/title")
    public Product getByName(@RequestParam String name) {
        return productService.getByName(name);
    }

    @PostMapping
        public Product add(@RequestBody Product student) {
        return productService.add(student);
    }

    @GetMapping("/delete/{id}")
    public void delete (@RequestParam Long id){
        productService.delete(id);
    }

}
