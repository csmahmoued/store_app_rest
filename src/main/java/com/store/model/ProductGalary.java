package com.store.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductGalary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productImgId;
	private String imgName;
	private String url;
	
        @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
        @JsonIgnore
	private Product product;

	
	public ProductGalary(String ImgName,String url) {
		this.imgName=ImgName;
		this.url=url;
		
	}
	
	public ProductGalary() {
		
	}
	
	public int getProductImgId() {
		return productImgId;
	}

	public void setProductImgId(int productImgId) {
		this.productImgId = productImgId;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	
}
