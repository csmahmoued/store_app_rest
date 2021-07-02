package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.model.Product;
import com.store.model.ProductGalary;

@Repository
public interface PgalaryRepository extends JpaRepository<ProductGalary, Integer> {

	List<String> findByProduct(Product product);
}
