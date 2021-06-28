package com.spring.supermarket.dao.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.supermarket.dao.CustomerDao;
import com.spring.supermarket.dao.VerifyOrderDao;

import com.spring.supermarket.model.VerifyOrder;

@Repository
public class VerifyOrderDaoImpl implements VerifyOrderDao {

	private SessionFactory session;

	private CustomerDao customer;

	/**
	 * 
	 */
	public VerifyOrderDaoImpl() {
	}

	/**
	 * @param session
	 * @param customer
	 */
	public VerifyOrderDaoImpl(SessionFactory session, CustomerDao customer) {
		this.session = session;
		this.customer = customer;
	}

	@SuppressWarnings("unchecked")
	public Set<VerifyOrder> findAll() {
		List<VerifyOrder> verifyOrderList = session.getCurrentSession().createCriteria(VerifyOrder.class).list();
		Set<VerifyOrder> verifyOrders = new HashSet<VerifyOrder>(verifyOrderList);
		return verifyOrders;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<VerifyOrder> findByCustomer(Long id) {

		List<VerifyOrder> verifyOrderList = session.getCurrentSession()
				.createQuery("from verifyOrder where customerId = :id").setString("id", "%" + id + "%").list();
		Set<VerifyOrder> verifyOrders = new HashSet<>(verifyOrderList);
		return verifyOrders;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<VerifyOrder> findByOrderProduct(Long id) {
		List<VerifyOrder> verifyOrderList = session.getCurrentSession()
				.createQuery("from verifyOrder where productId = :id").setString("id", "%" + id + "%").list();
		Set<VerifyOrder> verifyOrders = new HashSet<>(verifyOrderList);
		return verifyOrders;
	}

}
