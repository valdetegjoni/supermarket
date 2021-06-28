package com.spring.supermarket.dao;

import java.util.Set;

import com.spring.supermarket.model.OrderProduct;

public interface OrderProductDao {

	public Set<OrderProduct> findByCustomer(Long id);

	public OrderProduct createOrderProduct(OrderProduct orderProduct);
}
