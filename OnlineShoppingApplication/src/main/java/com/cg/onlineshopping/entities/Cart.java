package com.cg.onlineshopping.entities;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="cart_table")
public class Cart {

	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cart_seq")
	@SequenceGenerator(name="cart_seq",sequenceName="cart_seq", allocationSize=1)
	private int cartId;

	//private Map<Product, Integer>products; // product and quantity 

	//mapping
    //@JsonIgnore
	//@OneToMany(fetch = FetchType.EAGER, mappedBy = "cart")
	//@OneToMany(cascade=CascadeType.REFRESH)
	//@JoinColumn(name = "product_id")
	//@ManyToMany
	//@JoinTable(name = "cart_product_table", joinColumns = { @JoinColumn(name = "cart_id") }, inverseJoinColumns = { @JoinColumn(name = "product_id") })
	//Set<Product> product= new HashSet<>();


	@OneToOne
	@JoinColumn(name="customer_id")
	private Customer customerCart;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product productCart;


	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int cartId, Customer customerCart, Product productCart) {
		super();
		this.cartId = cartId;
		this.customerCart = customerCart;
		this.productCart = productCart;
	}


	public int getCartId() {
		return cartId;
	}


	public void setCartId(int cartId) {
		this.cartId = cartId;
	}


	public Customer getCustomerCart() {
		return customerCart;
	}


	public void setCustomerCart(Customer customerCart) {
		this.customerCart = customerCart;
	}


	public Product getProductCart() {
		return productCart;
	}


	public void setProductCart(Product productCart) {
		this.productCart = productCart;
	}


	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", customerCart=" + customerCart + ", productCart=" + productCart + "]";
	}
}

	