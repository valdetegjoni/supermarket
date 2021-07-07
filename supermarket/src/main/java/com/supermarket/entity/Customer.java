package com.supermarket.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "customer")
@NamedQuery(name = "customer.findAll", query = "from Customer cu")
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_CUSTOMER_ID_GENERATOR")
	@SequenceGenerator(name = "SP_CUSTOMER_ID_GENERATOR", sequenceName = "sp_customer_id_seq", allocationSize = 1)

	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "firstname", nullable = false, length = 255)
	private String firstName;

	@Column(nullable = false, length = 255, name = "lastname")

	private String lastName;

	@Column(nullable = false, length = 255)
	private String address;

	@Column(nullable = false)
	private Long telephone;

	@Column(length = 50)
	private String email;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // fetch = FetchType.LAZY)
	@JsonIgnore
	@OrderBy("id ASC")
	Set<OrderProduct> orderProducts = new HashSet<>();

	@JsonManagedReference
	@OrderBy("id ASC")
	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // , fetch = FetchType.LAZY)
	Set<VerifyOrder> verifyOrders = new HashSet<VerifyOrder>();

	@Fetch(FetchMode.JOIN)
	@ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY)
	private Set<Cashier> cashiers = new HashSet<>();

	@JsonIgnore // @JsonManagedReference
	@OrderBy("id ASC") // @Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL) // , fetch = FetchType.LAZY)
	private Set<InvoiceReceipt> invoiceReceipts;

	/**
	 * 
	 */
	public Customer() {
	}

	/**
	 * @param orderProducts
	 * @param verifyOrders
	 */
	public Customer(Set<OrderProduct> orderProducts, Set<VerifyOrder> verifyOrders) {
		super();
		this.orderProducts = orderProducts;
		this.verifyOrders = verifyOrders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<VerifyOrder> getVerifyOrders() {
		return verifyOrders;
	}

	public void setVerifyOrders(Set<VerifyOrder> verifyOrders) {
		this.verifyOrders = verifyOrders;
	}

	public Set<Cashier> getCashiers() {
		return cashiers;
	}

	public void setCashiers(Set<Cashier> cashiers) {
		this.cashiers = cashiers;
	}

	public Set<InvoiceReceipt> getInvoiceReceipts() {
		return invoiceReceipts;
	}

	public void setInvoiceReceipts(Set<InvoiceReceipt> invoiceReceipts) {
		this.invoiceReceipts = invoiceReceipts;
	}

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", telephone=" + telephone + ", email=" + email + "]";
	}

}
