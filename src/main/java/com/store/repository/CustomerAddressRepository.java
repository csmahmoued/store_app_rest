package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.model.CustomerAddress;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {

}
