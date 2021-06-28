package com.spring.supermarket.dao;

import java.util.Set;

import com.spring.supermarket.model.InvoiceReceipt;

public interface InvoiceReceiptDao {

	public Set<InvoiceReceipt> findByCustomer(Long id);

	public Set<InvoiceReceipt> findByCashier(Long id);

}
