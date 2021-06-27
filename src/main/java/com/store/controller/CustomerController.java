package com.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.Customer;
import com.store.model.CustomerAddressInfo;
import com.store.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	@PostMapping("/add-customer")
	public ResponseEntity<Void> saveCustomer(@RequestBody Customer customer){
		customerService.addCustomer(customer);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PostMapping("/add-address")
	public ResponseEntity<Void> saveAddress(@RequestBody CustomerAddressInfo customerAddress){
		customerService.addCustomerAddress(customerAddress);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}	
	
	@GetMapping("/all-customer")
	public ResponseEntity<List<Customer>> getCustomers(){
		return new ResponseEntity<>(customerService.getAllCustomer(),HttpStatus.OK);
	}
	
	
	
	@GetMapping("/customer/{cust_id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int cust_id){
		return new ResponseEntity<>(customerService.getCustomerById(cust_id),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/del-customer/{cust_id}")
	public ResponseEntity<Void> removeCustomer(@PathVariable int cust_id){
		customerService.delCustomer(cust_id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
