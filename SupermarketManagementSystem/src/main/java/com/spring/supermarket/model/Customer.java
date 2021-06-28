
package com.spring.supermarket.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

	@Column(nullable = false, length = 255)
	private String firstName;

	@Column(nullable = false, length = 255)
	private String lastName;

	@Column(nullable = false, length = 255)
	private String address;

	@Column(nullable = false)
	private Long telephone;

	@Column(length = 50)
	private String email;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	@Fetch(FetchMode.JOIN)
	Set<OrderProduct> orderProducts = new HashSet<>();

	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	Set<VerifyOrder> verifyOrders = new HashSet<VerifyOrder>();

	@Fetch(FetchMode.JOIN)
	@ManyToMany(mappedBy = "customers", fetch = FetchType.LAZY)
	private Set<Cashier> cashiers = new HashSet<>();

	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private Set<InvoiceReceipt> invoiceReceipts;

	/**
	 * 
	 */
	public Customer() {
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
				+ ", telephone=" + telephone + ", email=" + email + ", orderProducts=" + orderProducts
				+ ", verifyOrders=" + verifyOrders + ", cashiers=" + cashiers + ", invoiceReceipts=" + invoiceReceipts
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cashiers, email, firstName, id, invoiceReceipts, lastName, orderProducts,
				telephone, verifyOrders);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(cashiers, other.cashiers)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(invoiceReceipts, other.invoiceReceipts)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(orderProducts, other.orderProducts)
				&& Objects.equals(telephone, other.telephone) && Objects.equals(verifyOrders, other.verifyOrders);
	}

}
