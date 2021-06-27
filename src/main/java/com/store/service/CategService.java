package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.model.Category;
import com.store.repository.CatgRepository;

@Service
public class CategService {

	private CatgRepository catgRepository;

	public CategService(CatgRepository catgRepository) {
		this.catgRepository = catgRepository;
	}
	
	
	public void addCategory(Category category) {
		catgRepository.save(category);
	}
	
	public List<Category> getAllCatgs(){
		return catgRepository.findAll();
	}
	
	public Category getCatg(int catgId) {
		return catgRepository.findById(catgId).get();
	}
	
	public void delCatg(int catgId) {
		catgRepository.deleteById(catgId);
	}
	
	public Category getCatgByName(String catgName) {
		return catgRepository.findByCatgName(catgName);
	}
	
	
	
	
}
