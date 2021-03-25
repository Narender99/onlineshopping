package com.cg.onlineshopping.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.CartNotFoundException;
import com.cg.onlineshopping.repository.CartRepository;
import com.cg.onlineshopping.repository.ProductRepository;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;
	@Autowired 
	ProductRepository productRepo;
	
	Logger logger = LoggerFactory.getLogger(CartServiceImpl.class);

	/*@Override
	public Cart addProductToCart(Cart cart, Product p, int quantity) {
		p.setQuantity(quantity);
		productRepo.save(p);
		cartRepo.save(cart);
		return cart;
	}*/
	@Override
	public Cart addCart(Cart cart) {
		logger.info("Cart addCart()");

		if(cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else {
			cartRepo.save(cart);
			return cart;
		}
		
	}
	
	@Override
	public Cart removeCart(int cartId)
	{
		logger.info("Cart removeCart()");
		Cart cart = cartRepo.findById(cartId).get();
		if(cart == null)
			throw new CartNotFoundException("Cart Not Found");
		else {
			cartRepo.delete(cart);
			return cart;
		}
	}
	
	@Override
	public Cart viewCustomer(int customerId)
	{
		logger.info("Cart viewCustomer()");
		Cart cart = cartRepo.viewCartByCustomerId(customerId);
		if(cart==null)
			throw new CartNotFoundException("Cart Not Found");
		else
			return cart;
	}
	
	}
/*
	@Override
	public Cart removeProductFromCart(Cart cart, Product p) {
		int id = p.getProductId();
		cartRepo.deleteById(id);
		return cart;
	}

	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		p.setQuantity(quantity);
		productRepo.save(p);
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public Cart removeAllProducts(Cart cart) {
		cartRepo.delete(cart);
		return cart;
	}

	@Override
	public List<Product> viewAllProducts(Cart cart) {
		List<Product> list = new ArrayList<>(cart.getProduct());
		return list;
		
	}

}*/
