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
import com.spring.supermarket.dao.EmployeeStaffDao;
import com.spring.supermarket.dao.InvoiceReceiptDao;
import com.spring.supermarket.model.Cashier;
import com.spring.supermarket.model.Customer;
import com.spring.supermarket.model.EmployeeStaff;
import com.spring.supermarket.model.InvoiceReceipt;

@Repository
public class CashierDaoImpl implements CashierDao {

	// @Autowired
	private SessionFactory session;

	// @Autowired
	private CustomerDao customerDao;

	// @Autowired
	private EmployeeStaffDao employeeStaffDao;

	// @Autowired
	private InvoiceReceiptDao invoiceReceiptDao;

	/**
	 * @param session
	 * @param customerDao
	 * @param employeeStaffDao
	 * @param invoiceReceiptDao
	 */
	public CashierDaoImpl(SessionFactory session, CustomerDao customerDao, EmployeeStaffDao employeeStaffDao,
			InvoiceReceiptDao invoiceReceiptDao) {
		this.session = session;
		this.customerDao = customerDao;
		this.employeeStaffDao = employeeStaffDao;
		this.invoiceReceiptDao = invoiceReceiptDao;
	}

	/**
	 * 
	 */
	public CashierDaoImpl() {
	}

	public Cashier findById(Long id) {
		return (Cashier) session.getCurrentSession().get(Cashier.class, id);
	}

	@SuppressWarnings("unchecked")
	public Set<Cashier> findAll() {
		List<Cashier> cashierList = session.getCurrentSession().createQuery("from Cashier").list();
		Set<Cashier> cashiers = new HashSet<>(cashierList);
		return cashiers;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Customer> findByCashier(Long id) {
		List<Customer> customerList = session.getCurrentSession()
				.createQuery("from customer c join  c.applyPayment a where a.cashierId = :id")
				.setString("id", "%" + id + "%").list();
		Set<Customer> customers = new HashSet<>(customerList);
		return customers;
	}

	@SuppressWarnings("unchecked")
	public Set<Cashier> findCashiersByCustomer(Long id) {
		List<Cashier> cashierList = session.getCurrentSession()
				.createQuery("from cashier c join c.applyPayment a where a.customerId = :id")
				.setString("id", "%" + id + "%").list();
		Set<Cashier> cashiers = new HashSet<>(cashierList);
		return cashiers;
	}

	@SuppressWarnings("unchecked")
	public Set<Cashier> findByCustomer(Long id) {

		List<Cashier> cashierList = session.getCurrentSession()
				.createQuery("from cashier c join c.applyPayment a where a.customerId = :id")
				.setString("id", "%" + id + "%").list();
		Set<Cashier> cashiers = new HashSet<>(cashierList);
		return cashiers;
	}

	public void deleteCashierBy(String email) {
		Query query = (Query) session.getCurrentSession().createQuery("delete from cashier where email =: email");
		query.setParameter("email", email);
		query.executeUpdate();
	}

	public void deleteCashierById(Long id) {
		Cashier cashier = findById(id);
		session.getCurrentSession().delete(cashier);
	}

	public Cashier findByEmail(String email) {
		Criteria criteria = session.getCurrentSession().createCriteria(Cashier.class);
		criteria.add(Restrictions.eq("email", email));
		return (Cashier) criteria.uniqueResult();
	}

	public Cashier createCashier(Cashier cashier) {
		Cashier cashierNew = new Cashier();
		prepareCashier(cashierNew, cashier);
		session.getCurrentSession().persist(cashierNew);
		return cashierNew;
	}

	public Cashier updateCashier(Cashier cashier) {
		Cashier cashierUpdated = new Cashier();
		prepareCashier(cashierUpdated, cashier);
		session.getCurrentSession().saveOrUpdate(cashierUpdated);
		return cashierUpdated;
	}

	public void prepareCashier(Cashier cashierNew, Cashier cashier) {
		cashierNew.setFirstName(cashier.getFirstName());
		cashierNew.setLastName(cashier.getLastName());
		cashierNew.setBirthdate(cashier.getBirthdate());
		cashierNew.setEmail(cashier.getEmail());
		cashierNew.setTelephone(cashier.getTelephone());
		Set<EmployeeStaff> employeeStaffs = employeeStaffDao.findByCashier(cashier.getId());
		cashierNew.setEmployeeStaffs(employeeStaffs);
		Set<Customer> customers = customerDao.findByCashier(cashier.getId());
		cashierNew.setCustomers(customers);
		cashierNew.setAddress(cashier.getAddress());

		Set<InvoiceReceipt> invoiceReceipts = invoiceReceiptDao.findByCashier(cashier.getId());
		cashierNew.setInvoiceReceipts(invoiceReceipts);
	}

}
