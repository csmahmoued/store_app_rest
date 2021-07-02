package com.store.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.model.ProductGalary;

@Repository
public interface PgalaryRepository extends JpaRepository<ProductGalary, Integer> {

}
