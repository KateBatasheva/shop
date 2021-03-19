package ru.geekbrains.spring.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.shop.model.DTOs.CartDTO;
import ru.geekbrains.spring.shop.model.DTOs.ProductDTO;
import ru.geekbrains.spring.shop.model.entities.Cart;
import ru.geekbrains.spring.shop.model.entities.Product;
import ru.geekbrains.spring.shop.services.CartService;
import ru.geekbrains.spring.shop.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/products")
public class ShopController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping
    public Page<ProductDTO> getAll(@RequestParam (defaultValue = "0") Integer page,
                                   @RequestParam (defaultValue = "5") Integer size,
                                   @RequestParam (required = false) String direction,
                                   @RequestParam (defaultValue = "price") String sort) {
        return productService.getAll(page,size,direction,sort);
    }

//    @GetMapping ("/sort")
//    @ResponseBody
//    public List<Product> getAllSortByPrice (
//            @RequestParam (required = false) Integer max_price,
//            @RequestParam (required = false) Integer min_price,
//            @RequestParam (defaultValue = "0") Integer page,
//            @RequestParam (defaultValue = "5") Integer size,
//            @RequestParam (required = false) String direction
//    ) {
//        if (max_price != null && min_price != null){
//            return productService.getProductByPrice(max_price, max_price);
//        }
//        if (max_price !=null){
//            return productService.getProductByMaxPrice(max_price);
//        }
//        if (min_price != null){
//            return productService.getProductByMinPrice(min_price);
//        }
//        return productService.getAll(page,size,direction, null);
//    }

    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getById(id).get();
    }

//    @GetMapping("/title")
//    public Optional<Product> getByName(@RequestParam String title) {
//        return productService.getByName(title);
//    }

    @PostMapping
        public Product add(@RequestBody Product product) {
        return productService.add(product);
    }

    @GetMapping("/delete/{id}")
    public void delete (@PathVariable Long id){
        productService.delete(id);
    }
//
//    @GetMapping("/product")
//    public List<Product> getProbuctByPrice (@RequestParam Integer first, @RequestParam Integer second){
//        return productService.getProductByPrice(first,second);
//    }

    @GetMapping("/product")
    public List<Product> getProductByTitle (@RequestParam String title){
        return productService.getProdusctByTitle(title);
    }

    @PutMapping("/{id}")
    public Product put(@RequestBody ProductDTO product){
        Product pr = productService.getFullProduct(product.getId());
        pr.setPrice(product.getPrice());
        pr.setTitle(product.getTitle());
        pr.setCategory(productService.findCategoryByName(product.getCategory()));
        return pr;
    }

    @GetMapping ("/cart")
    public String showCart (){
        return cartService.showCart();
    }
//
//    @GetMapping ("/cart")
//    public Page<CartDTO> showCart (@RequestParam CartDTO cartDTO){
//        return cartService.showCart();
//    }

}
