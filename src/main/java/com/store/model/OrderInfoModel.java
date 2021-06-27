package com.store.model;

public class OrderInfoModel {

	private int productId;
	private int customerId;
	private int orderId;
	private float total;
	private float orderQuantity;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(float orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
	
}
