package com.spring.supermarket.dao;

import java.util.Set;

import com.spring.supermarket.model.Cashier;
import com.spring.supermarket.model.Customer;

public interface CashierDao {

	public Set<Customer> findByCashier(Long id) ;
	public Set<Cashier> findByCustomer(Long id);
	public Set<Cashier> findCashiersByCustomer(Long id);

}
