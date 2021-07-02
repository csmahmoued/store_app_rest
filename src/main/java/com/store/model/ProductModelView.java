package com.store.model;

import java.util.List;

public class ProductModelView {

	private int catgId;
	private int productId;
	private String productName;
	private float productPrice;
	private float productSellPrice;
	private List<String> imgs;
	
	
	
	
	
	

	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}
	public int getCatgId() {
		return catgId;
	}
	public void setCatgId(int catgId) {
		this.catgId = catgId;
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

	
	

}
