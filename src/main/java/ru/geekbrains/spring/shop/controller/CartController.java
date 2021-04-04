package ru.geekbrains.spring.shop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.shop.model.DTOs.CartDTO;
import ru.geekbrains.spring.shop.model.Cart;
import ru.geekbrains.spring.shop.services.CartService;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {

    @Autowired
    private Cart cart;

    @Autowired
    private CartService cartService;

    @GetMapping
    public CartDTO getCart() {
        return cartService.showCart();
    }

    @GetMapping("/add/{id}")
    public void addToCart(@PathVariable Long id) {
       cartService.addToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
       cartService.clear();
    }

}
