package com.spring.supermarket.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "invoiceReceipt")
@NamedQuery(name = "invoiceReceipt.findAll", query = " from InvoiceReceipt i")
public class InvoiceReceipt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_INVOICERECEIPT_ID_GENERATOR")
	@SequenceGenerator(name = "SP_INVOICERECEIPT_ID_GENERATOR", sequenceName = "sp_invoiceReceipt_id_seq", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "cashierId")
	private Cashier cashier;

	@ManyToOne(fetch = FetchType.LAZY) // , cascade = CascadeType.ALL
	@JoinColumn(name = "customerId") // @Fetch(FetchMode.JOIN)
	private Customer customer;

	@Column(name = "totalAmount", nullable = false)
	private Long totalAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;

	@Column(name = "price", nullable = false)
	private Long price;

	/**
	 * 
	 */
	public InvoiceReceipt() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "InvoiceReceipt [id=" + id + ", cashier=" + cashier + ", customer=" + customer + ", totalAmount="
				+ totalAmount + ", date=" + date + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cashier, customer, date, id, price, totalAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceReceipt other = (InvoiceReceipt) obj;
		return Objects.equals(cashier, other.cashier) && Objects.equals(customer, other.customer)
				&& Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(price, other.price) && Objects.equals(totalAmount, other.totalAmount);
	}

}
