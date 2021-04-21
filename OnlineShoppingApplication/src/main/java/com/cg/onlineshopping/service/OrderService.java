package com.cg.onlineshopping.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Order;

@Service
public interface OrderService {
	
	public List<Order> addOrder(Order[] order);
	
	public Order updateOrder(Order order);
	
	public Order removeOrder(int orderId);
	
	public Order viewOrder(Order order);
	
	//public List<Order> viewAllOrders(LocalDate date);
	
	//public List<Order> viewAllOrdersByLocation(String location);
	
	public Order viewAllOrderById(int id);
	
	public List<Order> viewAllOrdersByCustomer(int customerId);
	
	public void deleteOrdersByCustomerId(int customerId);

}
