package com.store.mapper;

import org.springframework.stereotype.Component;

import com.store.model.Category;
import com.store.model.Product;
import com.store.model.ProductCategoryModel;
import com.store.service.CategService;

import javassist.NotFoundException;

@Component
public class ProductMapper {

	
	private CategService categService;

	public ProductMapper(CategService categService) {
		this.categService = categService;
	}
	
	public Product convertProductViewToEntity(ProductCategoryModel model) {
		
		Category category=categService.getCatg(model.getCatgId());
	
		Product product=new Product();
		product.setProductName(model.getProductName());
		product.setProductPrice(model.getProductPrice());
		product.setCategory(category);
		product.setProductSellPrice(model.getProductSellPrice());
		
		return product;
		
	}
	
	
	
	
}
