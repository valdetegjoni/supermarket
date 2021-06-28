package com.spring.supermarket.dao.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.spring.supermarket.dao.OrderProductDao;
import com.spring.supermarket.dao.ProductDao;
import com.spring.supermarket.dao.VerifyOrderDao;
import com.spring.supermarket.model.OrderProduct;
import com.spring.supermarket.model.Product;
import com.spring.supermarket.model.VerifiedOrder;

public class ProductDaoImpl implements ProductDao {

	// @Autowired
	private SessionFactory session;

//	@Autowired
	private OrderProductDao orderProductDao;

	// @Autowired
	private VerifyOrderDao verifyOrderDao;

	/**
	 * @param session
	 * @param orderProductDao
	 * @param verifyOrderDao
	 */
	public ProductDaoImpl(SessionFactory session, OrderProductDao orderProductDao, VerifyOrderDao verifyOrderDao) {
		this.session = session;
		this.orderProductDao = orderProductDao;
		this.verifyOrderDao = verifyOrderDao;
	}

	/**
	 * 
	 */
	public ProductDaoImpl() {
	}

	@Override
	public Product findById(Long id) {
		return (Product) session.getCurrentSession().get(Product.class, id);
	}

	@Override
	public Product findByName(String name) {
		Criteria criteria = session.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("productName", name));
		return (Product) criteria.uniqueResult();
	}

	@Override
	public Product findByCategory(String category) {
		Criteria criteria = session.getCurrentSession().createCriteria(Product.class);
		criteria.add(Restrictions.eq("category", category));
		return (Product) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Product> findAll() {
		List<Product> productList = session.getCurrentSession().createQuery("from product").list();
		Set<Product> products = new HashSet<>(productList);
		return products;
	}

	@Override
	public void deleteProduct(Long id) {
		Product product = findById(id);
		session.getCurrentSession().delete(product);

	}

	@Override
	public Product createProduct(Product product) {
		return null;
	}

	@Override
	public Product updateProduct(Long id) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Product> findByCustomer(Long id) {
		List<Product> orderProductList = session.getCurrentSession()
				.createQuery("from product p join p.orderProduct o where p.id = : id").setString("id", "%" + id + "%")
				.list();
		Set<Product> orderProducts = new HashSet<Product>(orderProductList);
		return orderProducts;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Product> findVerifyOrderByProductId(Long id) {
		List<Product> verifyOrderList = session.getCurrentSession()
				.createQuery("from  product p join p.verifyOrder v where p.id = :id").setString("id", "%" + "%").list();
		Set<Product> verifyOrders = new HashSet<Product>(verifyOrderList);
		return verifyOrders;
	}

	@Override
	public Set<VerifiedOrder> findVerifiedOrderByProductId(Long id) {
		return null;
	}

	@Override
	public Set<OrderProduct> findByCashier(Long id) {
		return null;
	}

}
