package com.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Product;
import com.store.model.ProductModelView;
import com.store.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@PostMapping("/add-product")
	public ResponseEntity<ProductModelView> saveProduct(@RequestBody ProductModelView product){
		
		return new ResponseEntity(productService.addProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/all-products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.CREATED);		
	}
	
	
	
	
	
	
	
}
