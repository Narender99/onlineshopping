package com.cg.onlineshopping.controller;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.repository.OrderRepository;
import com.cg.onlineshopping.service.OrderService;

@RestController
@RequestMapping("/onlineshopping/api")
public class OrderRestController {

	
	@Autowired
    OrderService orderService;
    @Autowired
    OrderRepository orderRepo;
    
	Logger logger = LoggerFactory.getLogger(OrderRestController.class);

    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order) 
    {
    	logger.info("Order addOrder()");
    	orderRepo.save(order);
		return order;
    	
    }
    
   @PutMapping("/order")
   public Order updateOrder(@RequestBody Order order) {
	   logger.info("Order updateOrder()");
	  orderRepo.save(order);
	return order;
	  
   }
  
  @GetMapping("/order")
  public List<Order> viewAllOrder(){
	  logger.info("Order viewAllOrders()");
	  return orderRepo.findAll();
  }
 /*  
   @GetMapping("/order/{date}")
   public List<Order> viewOrdersByDate(@RequestBody LocalDate date) {
	   		logger.info("Order viewAllOrders()");

    return orderService.viewAllOrders(date);
}
   
   
   @GetMapping("/order/{location}")
   public List<Order> viewOrdersByLocation(@RequestBody String location) {
	   
	   logger.info("Order viewAllOrdersByLocation()");
	return orderService.viewAllOrdersByLocation(location);
	   
   }
 */  
   
   @DeleteMapping("/order/orderId")
   public Order removeOrder(@RequestBody int orderId) {
	   logger.info("Order removeOrder()");
	   return orderService.removeOrder(orderId);
   }
   
}
