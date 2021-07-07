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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orderProduct")
@NamedQuery(name = "OrderProduct.findAll", query = "from OrderProduct op")
public class OrderProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_ORDERPRODUCT_ID_GENERATOR")
	@SequenceGenerator(name = "SP_ORDERPRODUCT_ID_GENERATOR", sequenceName = "sp_orderProduct_id_seq", allocationSize = 1)

	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@JsonBackReference
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, fetch = FetchType.LAZY) // @ManyToOne(fetch = FetchType.LAZY, cascade =
															// CascadeType.ALL)
	@JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
	private Customer customer;
	@JsonBackReference
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, fetch = FetchType.LAZY) // @ManyToOne(fetch = FetchType.LAZY, cascade =
															// CascadeType.ALL)
	@JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
	private Product product;

	@Column(name = "date")
	private Date date;

	@Column(name = "details", length = 255)
	private String details;

	@Column(name = "quantity")
	private Long quantity;

	/**
	 * @param date
	 * @param details
	 * @param quantity
	 */
	public OrderProduct(Date date, String details, Long quantity) {
		super();
		this.date = date;
		this.details = details;
		this.quantity = quantity;
	}

	/**
	 * @param verifyOrders
	 */
	public OrderProduct(Set<VerifyOrder> verifyOrders) {
		super();
		this.verifyOrders = verifyOrders;
	}

	@OneToMany(mappedBy = "orderProduct", cascade = CascadeType.ALL) // , fetch = FetchType.LAZY)
	@OrderBy("id ASC")
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

}
