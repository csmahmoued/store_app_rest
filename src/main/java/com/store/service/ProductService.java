package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.mapper.ProductMapper;
import com.store.model.Product;
import com.store.model.ProductModelView;
import com.store.repository.ProductRepository;

@Service
public class ProductService {

	private ProductRepository productRepository;
	private ProductMapper productMapper;

	public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
		this.productRepository = productRepository;
		this.productMapper = productMapper;
	}



	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public Product getProductById(int productId) {
		return productRepository.getById(productId);
	}
	
	public Product addProduct(ProductModelView model) {
		Product  product = productMapper.convertProductViewToEntity(model);
		return productRepository.save(product);
	}
	
	
	
	
	
	
	
	
}
