package com.spring.supermarket.dao.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.spring.supermarket.dao.CashierDao;
import com.spring.supermarket.dao.CustomerDao;
import com.spring.supermarket.dao.InvoiceReceiptDao;
import com.spring.supermarket.dao.OrderProductDao;
import com.spring.supermarket.dao.VerifyOrderDao;
import com.spring.supermarket.model.Cashier;
import com.spring.supermarket.model.Customer;
import com.spring.supermarket.model.InvoiceReceipt;
import com.spring.supermarket.model.OrderProduct;
import com.spring.supermarket.model.VerifyOrder;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	// @Autowired
	private SessionFactory session;

	// @Autowired
	private CashierDao cashierDao;

	/**
	 * 
	 */
	public CustomerDaoImpl() {
	}

	/**
	 * @param session
	 * @param cashierDao
	 * @param verifyOrderDao
	 * @param invoiceReceiptDao
	 * @param orderProductDao
	 */
	public CustomerDaoImpl(SessionFactory session, CashierDao cashierDao, VerifyOrderDao verifyOrderDao,
			InvoiceReceiptDao invoiceReceiptDao, OrderProductDao orderProductDao) {
		this.session = session;
		this.cashierDao = cashierDao;
		this.verifyOrderDao = verifyOrderDao;
		this.invoiceReceiptDao = invoiceReceiptDao;
		this.orderProductDao = orderProductDao;
	}

//	@Autowired
	private VerifyOrderDao verifyOrderDao;

//	@Autowired
	private InvoiceReceiptDao invoiceReceiptDao;

//	@Autowired
	private OrderProductDao orderProductDao;

	public void setSession(SessionFactory session) {
		this.session = session;
	}

	public Customer findById(Long id) {
		return (Customer) session.getCurrentSession().get(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	public Set<Customer> findByCashier(Long id) {

		Set<Customer> customers = (Set<Customer>) session.getCurrentSession()
				.createQuery("from customer c join c.applyPayment where cashierId = :id")
				.setString("id", "%" + id + "%").list();

		return customers;
	}

	@SuppressWarnings("unused")
	public Customer findOneCustomerByCashier(Long id) {
		Customer customer = findById(id);
		Set<Cashier> cashiers = cashierDao.findCashiersByCustomer(id);
		return customer;
	}

	@SuppressWarnings("unused")
	public Set<Cashier> findOneWithCashier(Long id) {
		Customer customer = findById(id);
		Set<Cashier> cashiers = cashierDao.findByCustomer(id);
		return cashiers;
	}

	public Set<OrderProduct> findOneWithOrderProduct(Long id) {
		Customer customer = findById(id);
		Set<OrderProduct> orderProducts = orderProductDao.findByCustomer(customer.getId());
		return orderProducts;

	}

	@SuppressWarnings("unused")
	public Set<VerifyOrder> findOneWithVerifyOrder(Long id) {
		Customer customer = findById(id);
		Set<VerifyOrder> verifyOrder = verifyOrderDao.findByCustomer(id);

		return verifyOrder;
	}

	@SuppressWarnings("unused")
	public Set<InvoiceReceipt> findOneWithInvoiceReceipt(Long id) {
		Customer customer = findById(id);
		Set<InvoiceReceipt> invoiceReceipt = invoiceReceiptDao.findByCustomer(id);

		return invoiceReceipt;
	}

	@SuppressWarnings("unchecked")
	public Set<Customer> findAll() {
		List<Customer> customerList = session.getCurrentSession().createCriteria(Customer.class).list();// session.getCurrentSession().createQuery("from
																										// Customer").list();//
		Set<Customer> customers = new HashSet<Customer>(customerList);
		return customers;
	}

	public void deleteCustomerByEmail(String email) {
		Query query = (Query) session.getCurrentSession().createQuery("delete from Customer where email = :email");
		query.setParameter("email", email);
		query.executeUpdate();
	}

	public void deleteCustomerById(Long id) {
		Customer customer = findById(id);
		session.getCurrentSession().delete(customer.getId());
	}

	public Customer findByEmail(String email) {
		Criteria criteria = session.getCurrentSession().createCriteria(Customer.class);
		criteria.add(Restrictions.eq("email", email));
		return (Customer) criteria.uniqueResult();
	}

	@Override
	public Customer createCustomer(Customer customer) {

		Customer customerNew = new Customer();
		prepareCustomer(customerNew, customer);
		session.getCurrentSession().persist(customerNew);
		return customerNew;
	}

	public Customer updateCustomer(Customer customer) {
		Customer customerUpdated = new Customer();
		this.prepareCustomer(customerUpdated, customer);

		session.getCurrentSession().saveOrUpdate(customerUpdated);
		return customerUpdated;
	}

	public Customer prepareCustomer(Customer customerPrepared, Customer customer) {
		customerPrepared.setAddress(customer.getAddress());
		customerPrepared.setEmail(customer.getEmail());
		customerPrepared.setFirstName(customer.getFirstName());
		customerPrepared.setLastName(customer.getLastName());
		customerPrepared.setTelephone(customer.getTelephone());

		Set<Cashier> cashiers = cashierDao.findByCustomer(customer.getId());
		// Set<Cashier> cashiers = new HashSet<>(cashierList);
		customerPrepared.setCashiers(cashiers);

		Set<VerifyOrder> verifyOrders = verifyOrderDao.findByCustomer(customer.getId());
		customerPrepared.setVerifyOrders(verifyOrders);

		Set<InvoiceReceipt> invoiceReceipt = invoiceReceiptDao.findByCustomer(customer.getId());
		customerPrepared.setInvoiceReceipts(invoiceReceipt);

		Set<OrderProduct> orderProducts = orderProductDao.findByCustomer(customer.getId());
		// Set<OrderProduct> orderProducts = new HashSet<>(orderProductList);
		customerPrepared.setOrderProducts(orderProducts);

		return customerPrepared;
	}

	@Override
	public Set<Cashier> findOneByCashier(Long id) {
		Set<Cashier> cashiers = cashierDao.findByCustomer(id);
		return cashiers;
	}

}
