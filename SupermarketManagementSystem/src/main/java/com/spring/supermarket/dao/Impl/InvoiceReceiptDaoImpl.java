package com.spring.supermarket.dao.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.supermarket.dao.InvoiceReceiptDao;
import com.spring.supermarket.model.InvoiceReceipt;

@Repository
public class InvoiceReceiptDaoImpl implements InvoiceReceiptDao {

	/**
	 * 
	 */
	public InvoiceReceiptDaoImpl() {
	}

	// @Autowired
	private SessionFactory session;

	/**
	 * @param session
	 */
	public InvoiceReceiptDaoImpl(SessionFactory session) {
		this.session = session;
	}

	@Override
	public Set<InvoiceReceipt> findByCustomer(Long id) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<InvoiceReceipt> findByCashier(Long id) {
		List<InvoiceReceipt> invoiceReceiptList = session.getCurrentSession()
				.createQuery("from invoiceReceipt where cashierId = : id").setString("id", "%" + id + "%").list();
		Set<InvoiceReceipt> invoiceReceipts = new HashSet<InvoiceReceipt>(invoiceReceiptList);
		return invoiceReceipts;
	}

}
