package com.spring.supermarket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "orderProduct")
@NamedQuery(name = "OrderProduct.findAll", query = "from OrderProduct op")
public class OrderProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_ORDERPRODUCT_ID_GENERATOR")
	@SequenceGenerator(name = "SP_ORDERPRODUCT_ID_GENERATOR", sequenceName = "sp_orderProduct_id_seq", allocationSize = 1)

	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "productId")
	private Product product;

	@Column(name = "date")
	private Date date;

	@Column(name = "details", length = 255)
	private String details;

	@Column(name = "quantity")
	private Long quantity;

	@OneToMany(mappedBy = "orderProduct", fetch = FetchType.LAZY)
	Set<VerifyOrder> verifyOrders = new HashSet<>();

	public Set<VerifyOrder> getVerifyOrder() {
		return verifyOrders;
	}

	public void setVerifyOrder(Set<VerifyOrder> verifyOrder) {
		this.verifyOrders = verifyOrder;
	}

	/**
	 * 
	 */
	public OrderProduct() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", customer=" + customer + ", product=" + product + ", date=" + date
				+ ", details=" + details + ", quantity=" + quantity + ", verifyOrders=" + verifyOrders + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, date, details, id, product, quantity, verifyOrders);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderProduct other = (OrderProduct) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(date, other.date)
				&& Objects.equals(details, other.details) && Objects.equals(id, other.id)
				&& Objects.equals(product, other.product) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(verifyOrders, other.verifyOrders);
	}

}
