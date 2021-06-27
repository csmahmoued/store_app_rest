package com.store.model;

public class CustomerOrderInfo {

	private String customerName;
	private String productName;
	private float orderQuantity;
	private float productPrice;
	private float total;
	
	
	
	
	
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(float orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
	
}
