package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.model.Category;

@Repository
public interface CatgRepository extends JpaRepository<Category, Integer> {

	Category findByCatgName(String CatgName);
	
}
