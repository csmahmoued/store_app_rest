package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.mapper.CustomerMapper;
import com.store.model.Customer;
import com.store.model.CustomerAddress;
import com.store.model.CustomerAddressInfo;
import com.store.repository.CustomerAddressRepository;
import com.store.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository customerRepository;
	private CustomerAddressRepository addressRepository;
	private CustomerMapper customerMapper;
	

	public CustomerService(CustomerRepository customerRepository, CustomerAddressRepository addressRepository,
			CustomerMapper customerMapper) {

		this.customerRepository = customerRepository;
		this.addressRepository = addressRepository;
		this.customerMapper = customerMapper;
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void addCustomerAddress(CustomerAddressInfo customerAddressInfo) {
		CustomerAddress address=customerMapper.convertAddressModelToEntity(customerAddressInfo);
		addressRepository.save(address);
	}


	public Customer getCustomerById(int customerId) {
		return customerRepository.getById(customerId);
	}
	
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	
	}
	
	public void delCustomer(int custId) {
		customerRepository.deleteById(custId);
	}
	
	
	
}
