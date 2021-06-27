package com.store.mapper;

import org.springframework.stereotype.Component;

import com.store.model.Customer;
import com.store.model.CustomerOrderInfo;
import com.store.model.OrderDetails;
import com.store.model.OrderInfoModel;
import com.store.model.Product;
import com.store.repository.CustomerRepository;
import com.store.repository.ProductRepository;

@Component
public class OrderMapper {

	private ProductRepository productRepository;
	private CustomerRepository customerRepository;
	
	public OrderMapper(ProductRepository productRepository, CustomerRepository customerRepository) {
		this.productRepository = productRepository;
		this.customerRepository = customerRepository;
	}
	
	public OrderDetails converOrderToEntity(OrderInfoModel model)
	{
		Customer customer=customerRepository.getById(model.getCustomerId());
		Product product = productRepository.getById(model.getProductId());
		
		OrderDetails orderDetails =new OrderDetails();
		orderDetails.setCustomer(customer);
		orderDetails.setProduct(product);
		orderDetails.setOrderQuantity(model.getOrderQuantity());
		return orderDetails;
	}
	
	public CustomerOrderInfo coventOrderDetailsToViewModel(OrderDetails model) {
		
		CustomerOrderInfo customerInfo=new CustomerOrderInfo();
		customerInfo.setCustomerName(model.getCustomer().getCustomerName());
		customerInfo.setProductName(model.getProduct().getProductName());
		customerInfo.setOrderQuantity(model.getOrderQuantity());
		customerInfo.setProductPrice(model.getProduct().getProductPrice());
		customerInfo.setTotal(model.getOrderQuantity()* model.getProduct().getProductPrice());
		return customerInfo;
	}
	
	
	
	
	
	
}
