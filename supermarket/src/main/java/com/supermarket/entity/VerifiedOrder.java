package com.supermarket.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "verifiedOrder")
@NamedQuery(name = "VerifiedOrder.findAll", query = "from VerifiedOrder vo")
public class VerifiedOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_VERIFIEDORDER_ID_GENERATOR")
	@SequenceGenerator(name = "SP_VERIFIEDORDER_ID_GENERATOR", sequenceName = "sp_verifiedOrder_id_seq", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeStaffId", nullable = false)
	private EmployeeStaff employeeStaff;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId", nullable = false)
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "verifyOrderId", nullable = false)
	private VerifyOrder verifyOrder;

	/**
	 * 
	 */
	public VerifiedOrder() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeStaff getEmployeeStaff() {
		return employeeStaff;
	}

	public void setEmployeeStaff(EmployeeStaff employeeStaff) {
		this.employeeStaff = employeeStaff;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public VerifyOrder getVerifyOrder() {
		return verifyOrder;
	}

	public void setVerifyOrder(VerifyOrder verifyOrder) {
		this.verifyOrder = verifyOrder;
	}

}
