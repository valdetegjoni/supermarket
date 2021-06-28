package com.spring.supermarket.service;

import java.util.Set;

import com.spring.supermarket.model.Cashier;
import com.spring.supermarket.model.Customer;

public interface CustomerService {

	public Customer findById(Long id);

	public Set<Cashier> findOneWithCashier(Long id);

	public Set<Customer> findAll();

	public Customer createCustomer(Customer customer);

	public void deleteCustomerByEmail(String email);

	public Customer findByEmail(String email);

	public Customer updateCustomer(Customer customer);

	public Set<Cashier> findOneByCashier(Long id);

	public Set<Customer> findByCashier(Long id);
}
