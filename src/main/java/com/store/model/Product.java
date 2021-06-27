package com.store.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String productName;
	private float productPrice;
	private float productSellPrice;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="catg_id")
	private Category category;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<ProductGalary> galaries;
	

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private Set<OrderDetails> orderDetails=new HashSet<>();;
	
	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
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

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public float getProductSellPrice() {
		return productSellPrice;
	}

	public void setProductSellPrice(float productSellPrice) {
		this.productSellPrice = productSellPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public List<ProductGalary> getGalaries() {
		return galaries;
	}

	public void setGalaries(List<ProductGalary> galaries) {
		this.galaries = galaries;
	}

	

	
	
	
	
	
}
