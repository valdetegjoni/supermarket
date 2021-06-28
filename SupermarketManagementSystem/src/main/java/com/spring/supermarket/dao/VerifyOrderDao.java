package com.spring.supermarket.dao;

import java.util.Set;

import com.spring.supermarket.model.VerifyOrder;

public interface VerifyOrderDao {

	public Set<VerifyOrder> findByCustomer(Long id);

	public Set<VerifyOrder> findAll();

	public Set<VerifyOrder> findByOrderProduct(Long id);
}
