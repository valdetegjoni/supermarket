package com.spring.supermarket.service.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.supermarket.dao.CustomerDao;
import com.spring.supermarket.dao.OrderProductDao;
import com.spring.supermarket.model.Cashier;
import com.spring.supermarket.model.Customer;
import com.spring.supermarket.model.OrderProduct;
import com.spring.supermarket.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private OrderProductDao orderProductDao;

	/**
	 * @param customerDao
	 */
	public CustomerServiceImpl(CustomerDao customerDao, OrderProductDao orderProductDao) {
		this.customerDao = customerDao;
		this.orderProductDao = orderProductDao;
	}

	/**
	 * 
	 */
	public CustomerServiceImpl() {
	}

	@Transactional
	@Override
	public Customer findById(Long id) {
		return customerDao.findById(id);
	}

	@Transactional
	@Override
	public Set<Cashier> findOneWithCashier(Long id) {
		return customerDao.findOneWithCashier(id);
	}

	@Transactional
	@Override
	public Set<Customer> findAll() {
		return customerDao.findAll();
	}

	@Transactional
	@Override
	public Customer createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

	public Set<OrderProduct> findOrderProductByCustomer(Long id) {
		Set<OrderProduct> orderProductNew = orderProductDao.findByCustomer(id);
		return orderProductNew;
	}

	@Transactional
	@Override
	public void deleteCustomerByEmail(String email) {
		try {
			customerDao.deleteCustomerByEmail(email);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

	@Transactional
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	@Transactional
	@Override
	public Set<Cashier> findOneByCashier(Long id) {
		return customerDao.findOneByCashier(id);
	}

	@Transactional
	@Override
	public Set<Customer> findByCashier(Long id) {
		return customerDao.findByCashier(id);
	}

}
