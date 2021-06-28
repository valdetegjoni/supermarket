package com.spring.supermarket.dao.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.supermarket.dao.CustomerDao;
import com.spring.supermarket.dao.OrderProductDao;
import com.spring.supermarket.dao.ProductDao;
import com.spring.supermarket.dao.VerifyOrderDao;
import com.spring.supermarket.model.OrderProduct;
import com.spring.supermarket.model.VerifyOrder;

@Repository

public class OrderProductDaoImpl implements OrderProductDao {

	// @Autowired
	SessionFactory session;

//	@Autowired
	private CustomerDao customerDao;

//	@Autowired
	private ProductDao productDao;

//	@Autowired
	private VerifyOrderDao verifyOrderDao;

	/**
	 * 
	 */
	public OrderProductDaoImpl() {
	}

	/**
	 * @param session
	 * @param customerDao
	 * @param productDao
	 * @param verifyOrderDao
	 */
	public OrderProductDaoImpl(SessionFactory session, CustomerDao customerDao, ProductDao productDao,
			VerifyOrderDao verifyOrderDao) {
		this.session = session;
		this.customerDao = customerDao;
		this.productDao = productDao;
		this.verifyOrderDao = verifyOrderDao;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<OrderProduct> findByCustomer(Long id) {
		List<OrderProduct> orderProductList = session.getCurrentSession()
				.createQuery("from orderProduct where customerId = :id").setString("id", "%" + id + "%").list();
		Set<OrderProduct> orderProducts = new HashSet<>(orderProductList);
		return orderProducts;
	}

	public OrderProduct createOrderProduct(OrderProduct orderProduct) {
		OrderProduct orderProductNew = new OrderProduct();
		prepareOrderProduct(orderProductNew, orderProduct);
		session.getCurrentSession().persist(orderProductNew);
		return orderProductNew;
	}

	public OrderProduct prepareOrderProduct(OrderProduct orderProductNew, OrderProduct orderProduct) {
		orderProductNew.setDate(orderProduct.getDate());
		orderProductNew.setDetails(orderProduct.getDetails());
		orderProductNew.setQuantity(orderProduct.getQuantity());
		orderProductNew.setCustomer(customerDao.findById(orderProduct.getCustomer().getId()));
		orderProductNew.setProduct(productDao.findById(orderProduct.getProduct().getId()));

		Set<VerifyOrder> verifyOrders = verifyOrderDao.findByOrderProduct(orderProduct.getId());
		orderProductNew.setVerifyOrder(verifyOrders);
		return orderProductNew;

	}

}
