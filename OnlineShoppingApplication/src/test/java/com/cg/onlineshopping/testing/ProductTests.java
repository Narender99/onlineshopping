package com.cg.onlineshopping.testing;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.Product;
import com.cg.onlineshopping.exception.ProductNotFoundException;
import com.cg.onlineshopping.repository.ProductRepository;
import com.cg.onlineshopping.service.ProductService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class ProductTests {

	@Autowired
	ProductService productService;
	
	@MockBean
	ProductRepository productRepository;
	
	
	@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setProductName("Samsung");
		product.setPrice(25000);
		product.setColor("Blue");
		product.setDimension("4HD");
		product.setManufacturer("SamsungCompany");
		product.setQuantity(2);
		Cart cart = new Cart();
		cart.setCartId(6002);
		product.setCart(cart);
		Category cat = new Category();
		cat.setCatId(4002);
		product.setCategory(cat);
		Mockito.when(productRepository.save(product)).thenReturn(product);
		assertThat(productService.addProduct(product)).isEqualTo(product);
	}
	
	
	
   @Test
   public void testUpdate() {
	Product product = new Product();
	product.setProductId(50002);
	product.setProductName("Sony");
	product.setColor("Black");
	product.setPrice(65000);
	product.setDimension("2D");
	product.setManufacturer("SonyCompany");
	product.setQuantity(1);
	Cart cart = new Cart();
	cart.setCartId(6003);
	product.setCart(cart);
	Category cat = new Category();
	cat.setCatId(4003);
	product.setCategory(cat);
	Mockito.when(productRepository.findById(product.getProductId())).thenReturn(Optional.of(product));
    product.setPrice(56000);
   
   assertThat(productService.updateProduct(product)).isEqualTo(product);
   
	   
}
  
   
   @Test
   public void testViewProduct() {
	   Product product = new Product();
	    product.setProductId(5002);
		product.setProductName("Sony");
		product.setColor("Black");
		product.setPrice(65000);
		product.setDimension("2D");
		product.setManufacturer("SonyCompany");
		product.setQuantity(1);
		Cart cart = new Cart();
		cart.setCartId(6003);
		product.setCart(cart);
		Category cat = new Category();
		cat.setCatId(4003);
		Mockito.when(productRepository.findById(product.getProductId())).thenReturn(Optional.of(product));
		assertThat(productService.viewProduct(5002)).isEqualTo(product);

   }
   
   @Test
   public void testRemoveProduct() {
	   Product product = new Product();
	    product.setProductId(5002);
		product.setProductName("Sony");
		product.setColor("Black");
		product.setPrice(65000);
		product.setDimension("2D");
		product.setManufacturer("SonyCompany");
		product.setQuantity(1);
		Cart cart = new Cart();
		cart.setCartId(6003);
		product.setCart(cart);
		Category cat = new Category();
		cat.setCatId(4003);
		 Mockito.when(productRepository.existsById(product.getProductId())).thenReturn(false);
	       assertFalse(productRepository.existsById(product.getProductId()));
	    }
   
  
 
   @Test
   public void testGetProductsException() throws ProductNotFoundException{
	   int id = 5005;
	   assertThrows(ProductNotFoundException.class, () -> productService.viewProduct(id));
	   System.out.println("Product Id cannot be retervied");
   
   }
   
  @Test
  public void testViewAllProduct() {
	   List<Product> product = new ArrayList<>();
	        Mockito.when(productRepository.findAll()).thenReturn(product);
	        Exception ex = assertThrows(ProductNotFoundException.class, ()-> productService.viewAllProducts());
	        assertEquals("No Products Found", ex.getMessage());
	        
	    }
	
  
  
  
  }
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
	
	
