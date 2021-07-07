package com.supermarket.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cashier")
@NamedQuery(name = "cashier.findAll", query = " from Cashier c")
public class Cashier {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_CASHIER_ID_GENERATOR")
	@SequenceGenerator(name = "SP_CASHIER_ID_GENERATOR", sequenceName = "sp_cashier_id_seq", allocationSize = 1)

	@Column(name = "id", unique = true, nullable = false)
	private Long cashierId;

	@Column(name = "firstName", nullable = false, length = 255)
	private String firstName;

	@Column(name = "lastName", nullable = false, length = 255)
	private String lastName;

	// @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthdate", nullable = false)
	@Type(type = "timestamp")
	private Date birthdate;

	@Column(nullable = false, length = 255)
	private String address;

	@Column(nullable = false)
	private Long telephone;

	@Column(length = 50)
	private String email;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "applyPayment", joinColumns = { @JoinColumn(name = "cashierId") }, inverseJoinColumns = {
			@JoinColumn(name = "customerId") })
	Set<Customer> customers = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "submitProduct", joinColumns = { @JoinColumn(name = "cashierId") }, inverseJoinColumns = {
			@JoinColumn(name = "employeeStaffId") })
	Set<EmployeeStaff> employeeStaffs = new HashSet<>();

	@JsonIgnore // @JsonManagedReference
	@OneToMany(mappedBy = "cashier")
	private Set<InvoiceReceipt> invoiceReceipts;

	/**
	 * 
	 */
	public Cashier() {
	}

	public Long getId() {
		return cashierId;
	}

	public void setId(Long id) {
		this.cashierId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Set<EmployeeStaff> getEmployeeStaffs() {
		return employeeStaffs;
	}

	public void setEmployeeStaffs(Set<EmployeeStaff> employeeStaffs) {
		this.employeeStaffs = employeeStaffs;
	}

	public Set<InvoiceReceipt> getInvoiceReceipts() {
		return invoiceReceipts;
	}

	public void setInvoiceReceipts(Set<InvoiceReceipt> invoiceReceipts) {
		this.invoiceReceipts = invoiceReceipts;
	}

}
