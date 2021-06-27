package com.store.mapper;

import org.springframework.stereotype.Component;

import com.store.model.Customer;
import com.store.model.CustomerAddress;
import com.store.model.CustomerAddressInfo;
import com.store.repository.CustomerRepository;
import com.store.service.CustomerService;

@Component
public class CustomerMapper {

	private CustomerRepository customerRepository;
	
	public CustomerMapper(CustomerRepository customerRepository) {
	
		this.customerRepository = customerRepository;
	}




	public CustomerAddress convertAddressModelToEntity(CustomerAddressInfo model) {
		
		Customer customer=customerRepository.findById(model.getCustomerId()).get();
		CustomerAddress address=new CustomerAddress();
		address.setCity(model.getCity());
		address.setCountry(model.getCountry());
		address.setState(model.getState());
		address.setCustomer(customer);
		address.setStreet(model.getStreet());
		return address; 
	
	}
	
}
