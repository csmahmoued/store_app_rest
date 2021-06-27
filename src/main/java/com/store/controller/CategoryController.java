package com.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Category;
import com.store.service.CategService;


@RestController
@CrossOrigin
public class CategoryController {

	private CategService categService;

	public CategoryController(CategService categService) {
		this.categService = categService;
	}
	
	
	@PostMapping("/add-catg")
	public ResponseEntity<Void> saveCatg(@RequestBody Category category){	
		categService.addCategory(category);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/all-catg")
	public ResponseEntity<List<Category>> getAllCategories(){
		return new ResponseEntity<>(categService.getAllCatgs(),HttpStatus.OK);
	}
	
	@GetMapping("/catg/{catg_name}")
	public ResponseEntity<Category> searchCatgByName(@PathVariable String catg_name){
		return new ResponseEntity<>(categService.getCatgByName(catg_name),HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
