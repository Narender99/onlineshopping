package com.cg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.service.CartService;

@RestController
@RequestMapping("/onlineshopping/api")
public class CartRestController {
    
	@Autowired
    CartService cartService;
   
    @PostMapping("/cart")
    /*public Cart addProductToCart(@RequestBody Cart cart, @RequestBody Product product, @RequestBody int quantity)
    {
        return cartService.addProductToCart(cart, product, quantity);
    }*/
    public Cart addCart(@RequestBody Cart cart)
    {
        return cartService.addCart(cart);
    }
   
    @DeleteMapping("/cart")
    public Cart removeProductFromCart(@RequestBody Cart cart, @RequestBody Product product)
    {
        return cartService.removeProductFromCart(cart, product);
    }
   
    @DeleteMapping("/cartAll")
    public Cart removeAllProducts(@RequestBody Cart cart)
    {
        return cartService.removeAllProducts(cart);
    }
   
    @PutMapping("/cart")
    public Cart updateProductQuantity(@RequestBody Cart cart, @RequestBody Product p, @RequestBody int quantity)
    {
        return cartService.updateProductQuantity(cart, p, quantity);
    }
    @GetMapping("/cart")
    public List<Product> viewAllProducts(@RequestBody Cart cart)
    {
        return cartService.viewAllProducts(cart);
    }
}
