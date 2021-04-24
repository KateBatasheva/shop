package ru.geekbrains.spring.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.shop.model.DTOs.CartDTO;
import ru.geekbrains.spring.shop.model.Cart;
import ru.geekbrains.spring.shop.model.entities.OrderProduct;
//import ru.geekbrains.spring.shop.repository.CartRepository;

@Service
@RequiredArgsConstructor
public class CartService {

//     private Cart cart = Cart.getCart();
    private final Cart cart;

     @Autowired
     ProductService productService;

//     private CartRepository cartRepository;

//    public Cart addProduct (Product product){
//       cart.getCart().getProducts().add(product);
//       return cart;
//    }
//
//    public Cart deleteProduct (Product product){
//        cart.getCart().getProducts().remove(product);
//        return cart;
//    }

//    public String showCart (){
////    public Page<CartDTO> showCart (){
//        CartDTO cartDTO = new CartDTO(cart.getCart());
////        return new PageRequest(0, 10, Sort.by(cartDTO.getName()));
//        return cartDTO.toString();
//    }

    public CartDTO showCart (){
        return new CartDTO(cart);
    }

    private void addToCart (OrderProduct product){
        cart.getProducts().add(product);
    }

    private void removeFromCart (OrderProduct product){
        cart.getProducts().remove(product);
    }

    public void addToCart (Long id){
        if(cart.getProducts().size() == 0){
            addToCart(new OrderProduct(productService.getByIdProduct(id).get()));
        } else {
        for (OrderProduct p: cart.getProducts()) {
            if (p.getProduct().getId().equals(id)) {
                p.incrementQuantity();
            } else {
                addToCart(new OrderProduct(productService.getByIdProduct(id).get()));
                return;
            }
            return;
        }
        }
        recalculate();
    }

    public void removeFromCart (Long id){
        for (OrderProduct p: cart.getProducts()){
            if (p.getProduct().getId().equals(id)) {
                if (p.getQuantity() == 1){
                    removeFromCart(p);
                } else {
                    p.decrementQuantity();
                }
                return;
            } else {
                throw new RuntimeException("Not found product in the cart");
            }
        }
        recalculate();
    }

    public void clear (){
        cart.getProducts().clear();
    }

    private void recalculate() {
        cart.setTotalCartPrice(0);
        int totalPrice = 0;
        for (OrderProduct o : cart.getProducts()) {
            totalPrice += o.getTotalPrice();
        }
        cart.setTotalCartPrice(totalPrice);
    }

}
