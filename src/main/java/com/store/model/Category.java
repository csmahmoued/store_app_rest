package com.store.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catgId;
	private String catgName;
	private String catgDesc;
	
	@OneToMany(mappedBy = "category")
	@JsonIgnore
	private List<Product> productList;

	public int getCatgId() {
		return catgId;
	}

	public void setCatgId(int catgId) {
		this.catgId = catgId;
	}

	public String getCatgName() {
		return catgName;
	}   

	public void setCatgName(String catgName) {
		this.catgName = catgName;
	}

	public String getCatgDesc() {
		return catgDesc;
	}

	public void setCatgDesc(String catgDesc) {
		this.catgDesc = catgDesc;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	
	
	


}

