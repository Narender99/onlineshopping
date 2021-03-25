package com.cg.onlineshopping.testing;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.onlineshopping.entities.Cart;
import com.cg.onlineshopping.entities.Category;
import com.cg.onlineshopping.entities.Customer;
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
public class ProductServiceTest {

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
	public void testViewProductsByCategory()
	{
		Product product1 = new Product();
		product1.setProductName("LG TV");
		product1.setPrice(18000.0);
		product1.setColor("Red");
		product1.setDimension("3D");
		product1.setSpecification("HD");
		product1.setManufacturer("LG");
		product1.setQuantity(2);
		
		Category cat1 = new Category();
		cat1.setCatId(1005);
		cat1.setCategoryName("Electronics");
		Cart cart1 = new Cart();
		cart1.setCartId(5002);
		Customer cust1 = new Customer();
		cust1.setFirstName("Ayush");
		cust1.setLastName("Sukla");
		cust1.setMobileNumber("90385857");
		cust1.setAddress("Mumbai");
		cust1.setEmail("ayz@g.com");
		cart1.setCustomerCart(cust1);
		
		product1.setCategory(cat1);
		product1.setCart(cart1);
		
		Product product2 = new Product();
		product2.setProductName("LG TV");
		product2.setPrice(18000.0);
		product2.setColor("Red");
		product2.setDimension("3D");
		product2.setSpecification("HD");
		product2.setManufacturer("LG");
		product2.setQuantity(2);
		
		Category cat2 = new Category();
		cat2.setCatId(1005);
		cat2.setCategoryName("Electronics");
		Cart cart2 = new Cart();
		cart2.setCartId(5002);
		Customer cust2 = new Customer();
		cust2.setFirstName("Ayush");
		cust2.setLastName("Sukla");
		cust2.setMobileNumber("90385857");
		cust2.setAddress("Mumbai");
		cust2.setEmail("ayz@g.com");
		cart2.setCustomerCart(cust2);
		
		product2.setCategory(cat2);
		product2.setCart(cart2);
		
		List<Product> product = new ArrayList<>();
		product.add(product1); product.add(product2);
		Mockito.when(productRepository.viewAllProductsByCategory(product.get(0).getCategory().getCatId())).thenReturn(product);
		assertThat(productService.viewProductsByCategory(product.get(0).getCategory().getCatId())).isEqualTo(product);
	}
  
  @Test
	public void testViewAllProducts()
	{
		Product product1 = new Product();
		product1.setProductName("LG TV");
		product1.setPrice(18000.0);
		product1.setColor("Red");
		product1.setDimension("3D");
		product1.setSpecification("HD");
		product1.setManufacturer("LG");
		product1.setQuantity(2);
		
		Category cat1 = new Category();
		cat1.setCatId(1005);
		cat1.setCategoryName("Electronics");
		Cart cart1 = new Cart();
		cart1.setCartId(5002);
		Customer cust1 = new Customer();
		cust1.setFirstName("Ayush");
		cust1.setLastName("Sukla");
		cust1.setMobileNumber("90385857");
		cust1.setAddress("Mumbai");
		cust1.setEmail("ayz@g.com");
		cart1.setCustomerCart(cust1);
		
		product1.setCategory(cat1);
		product1.setCart(cart1);
		
		Product product2 = new Product();
		product2.setProductName("LG TV");
		product2.setPrice(18000.0);
		product2.setColor("Red");
		product2.setDimension("3D");
		product2.setSpecification("HD");
		product2.setManufacturer("LG");
		product2.setQuantity(2);
		
		Category cat2 = new Category();
		cat2.setCatId(1005);
		cat2.setCategoryName("Electronics");
		Cart cart2 = new Cart();
		cart2.setCartId(5002);
		Customer cust2 = new Customer();
		cust2.setFirstName("Ayush");
		cust2.setLastName("Sukla");
		cust2.setMobileNumber("90385857");
		cust2.setAddress("Mumbai");
		cust2.setEmail("ayz@g.com");
		cart2.setCustomerCart(cust2);
		
		product2.setCategory(cat2);
		product2.setCart(cart2);
		
		List<Product> product = new ArrayList<>();
		product.add(product1); product.add(product2);
		Mockito.when(productRepository.findAll()).thenReturn(product);
		
		assertThat(productService.viewAllProducts()).isEqualTo(product);
	}
  
  
  
  }
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
	
	
