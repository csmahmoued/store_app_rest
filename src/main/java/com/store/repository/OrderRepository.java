package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.model.Customer;
import com.store.model.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetails, Integer> {

	List<OrderDetails> findByCustomer(Customer customer);
	
}
