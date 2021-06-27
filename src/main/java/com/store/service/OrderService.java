package com.store.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.store.mapper.OrderMapper;
import com.store.model.Customer;
import com.store.model.CustomerOrderInfo;
import com.store.model.OrderDetails;
import com.store.model.OrderInfoModel;
import com.store.repository.CustomerRepository;
import com.store.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepository;
	private OrderMapper orderMapper;
	private CustomerRepository customerRepository;

	public OrderService(OrderRepository orderRepository, OrderMapper orderMapper,
			CustomerRepository customerRepository) {
		this.orderRepository = orderRepository;
		this.orderMapper = orderMapper;
		this.customerRepository = customerRepository;
	}

	public void addOrder(OrderInfoModel OrderDetails) {
		OrderDetails details = orderMapper.converOrderToEntity(OrderDetails);
		orderRepository.save(details);
	}

	public List<CustomerOrderInfo> getCustomerOrders(int customerId) {

		Customer customer = customerRepository.findById(customerId).get();
		List<OrderDetails> details = orderRepository.findByCustomer(customer);

		return details.stream().map(custDetails -> this.orderMapper.coventOrderDetailsToViewModel(custDetails))
				.collect(Collectors.toList());

	}

}
