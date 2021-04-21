package com.cg.onlineshopping.entities;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.Set;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "product_table")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
	@SequenceGenerator(name="product_seq",sequenceName="product_seq", allocationSize=1)
	@Column(name = "product_id")
	private int productId;

	@Column(name = "product_name")
	@NotNull(message="Product name should not be null")
	private String productName;

	@Column(name = "price")
	//@NotEmpty(message="Price should not be empty")
	private double price;

	@Column(name = "color")
	@NotNull(message="Product color should not be null")
	private String color;

	@Column(name = "dimension")
	@NotNull(message="Product dimension should not be null")
	private String dimension;

	@Column(name = "specification")
	@NotEmpty(message="Product specification should not be empty")
	private String specification;

	@Column(name = "manufacturer")
	@NotEmpty(message="Product manufacturer should not be empty")
	private String manufacturer;

	//@Column(name = "quantity")
	//@Min(value=1,message="Quantity should be greater than zero")
	//private int quantity;

	@Column(name = "product_img")
     private String productImage;
	
	@ManyToOne
	@JoinColumn(name = "cat_id")
	private Category category;

	//@JsonIgnore
	//@ManyToMany(fetch=FetchType.LAZY,mappedBy="products")
	//private List<Order> order = new ArrayList<Order>();

	//@JsonIgnore
   // @ManyToMany(fetch=FetchType.LAZY,mappedBy="product")
	//private Set<Cart> cart= new TreeSet<Cart>();


	/*@ManyToOne
	private Cart cart;
    */


	public Product() {
		super();
	}

	
	public Product(int productId, @NotNull(message = "Product name should not be null") String productName,
			double price, @NotNull(message = "Product color should not be null") String color,
			@NotNull(message = "Product dimension should not be null") String dimension,
			@NotEmpty(message = "Product specification should not be empty") String specification,
			@NotEmpty(message = "Product manufacturer should not be empty") String manufacturer, String productImage,
			Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.color = color;
		this.dimension = dimension;
		this.specification = specification;
		this.manufacturer = manufacturer;
		this.productImage = productImage;
		this.category = category;
	}


	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + ", color="
				+ color + ", dimension=" + dimension + ", specification=" + specification + ", manufacturer="
				+ manufacturer + ", productImage=" + productImage + ", category=" + category + "]";
	}

	

	
	

}
