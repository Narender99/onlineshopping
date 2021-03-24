package com.cg.onlineshopping.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entities.Customer;
import com.cg.onlineshopping.entities.Order;
import com.cg.onlineshopping.entities.User;
import com.cg.onlineshopping.repository.CustomerRepository;
import com.cg.onlineshopping.repository.LoginRepository;
import com.cg.onlineshopping.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	private LoginRepository loginRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public Order addOrder(Order order) {
		orderRepo.save(order);
		return order;
	}

	@Override
	public Order updateOrder(Order order) {
		orderRepo.save(order);
		return order;
	}

	@Override
	public Order removeOrder(int orderId) {
		Order order = orderRepo.findById(orderId).get();
		orderRepo.delete(order);
		return order;
	}

	@Override
	public Order viewOrder(Order order) {
		return orderRepo.findById(order.getOrderId()).get();
	}

	@Override
	public List<Order> viewAllOrders(LocalDate date) {

		return orderRepo.viewAllOrderByDate(date);
	}

	@Override
	public List<Order> viewAllOrdersByLocation(String location) {
		int custId = orderRepo.viewCustomerByLocation(location);
        Customer cust = custRepo.findById(custId).get();
        List<Order> list = new ArrayList<>(cust.getProducts());
        return list;
    
	}

	@Override
	public List<Order> viewAllOrderByUserId(int userid) {
		
		User user = loginRepo.findById(userid).get();
        Customer cust = user.getCustomerUser();
        List<Order> list = new ArrayList<>(cust.getProducts());
        return list;
	}

}
