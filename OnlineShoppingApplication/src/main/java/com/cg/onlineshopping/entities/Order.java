package com.cg.onlineshopping.entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="order_table")
public class Order {


	@Id
	@Column(name = "order_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="order_seq")
	@SequenceGenerator(name="order_seq",sequenceName="order_seq", allocationSize=1)
	private int orderId;
	/*
	@Column(name = "order_status")
	@NotNull(message="Order status should not null")
	private String orderStatus;
	@Column(name = "order_date")
	private LocalDate orderDate;
	*/

	//@JsonIgnore
	//@ManyToMany
	//@JoinTable(name = "product_order", joinColumns = { @JoinColumn(name = "order_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	//Set<Product> products=new TreeSet<>();


	//@ManyToOne
	//@JoinColumn(name="address_id")
	//private Address addressOrder;

	

	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customerOrder;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productOrder;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, Customer customerOrder, Product productOrder) {
		super();
		this.orderId = orderId;
		this.customerOrder = customerOrder;
		this.productOrder = productOrder;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(Customer customerOrder) {
		this.customerOrder = customerOrder;
	}

	public Product getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(Product productOrder) {
		this.productOrder = productOrder;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerOrder=" + customerOrder + ", productOrder=" + productOrder
				+ "]";
	}

	



}
