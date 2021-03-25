package com.cg.onlineshopping.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/onlineshopping/api")
public class ProductRestController {

	Logger logger = LoggerFactory.getLogger(ProductRestController.class);
	@Autowired
	ProductService productService;

	@PostMapping("/product")
	public Product addProduct(@Valid@RequestBody Product product) {

		logger.info("Entered addProduct");

		return productService.addProduct(product);

	}
	/*
	@GetMapping("/product")
    public List<Product> viewAllProduct()
    {
		logger.info("Entered viewAllProducts");

        return productService.viewAllProducts();
    }
	 */
	@PutMapping("/product")
	public Product updateProduct(@Valid@RequestBody Product product)
	{
		logger.info("Entered updatedProducts");

		return productService.updateProduct(product);
	}

	@GetMapping("/product/{productId}")
	public Product viewProductById(@PathVariable("productId") int prodId)
	{
		logger.info("Entered viewProductById");

		return productService.viewProduct(prodId);
	}

	/*
    @GetMapping("/product/{catId}")
    public List<Product> viewProductsByCategory(@PathVariable("catId") int catId)
    {
    	logger.info("Entered viewProductByCategory");

        return productService.viewProductsByCategory(catId);
    }
	 */
	@DeleteMapping("/product/{prodId}")
	public Product removeProduct(@PathVariable("prodId") int prodId)
	{
		logger.info("removeProduct");

		return productService.removeProduct(prodId);
	}
}
