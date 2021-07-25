package com.store.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.store.model.Category;
import com.store.model.Product;
import com.store.model.ProductGalary;
import com.store.model.ProductModelView;
import com.store.service.CategService;

import javassist.NotFoundException;

@Component
public class ProductMapper {

	
	private CategService categService;

	public ProductMapper(CategService categService) {
		this.categService = categService;
	}
	
	public Product convertProductViewToEntity(ProductModelView model) {
		
		Category category=categService.getCatg(model.getCatgId());
	
		Product product=new Product();
		product.setProductId(model.getProductId());
		product.setProductName(model.getProductName());
		product.setProductPrice(model.getProductPrice());
		product.setCategory(category);
		product.setProductSellPrice(model.getProductSellPrice());
		
		return product;
		
	}
	
	public ProductModelView converProductToView(Product  product) {
		ProductModelView model=new ProductModelView();
		model.setProductName(product.getProductName());
		
		return null;
	}
	
	
	
}
