package com.supermarket.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "invoicereceipt")
@NamedQuery(name = "invoiceReceipt.findAll", query = " from InvoiceReceipt i")
public class InvoiceReceipt implements Serializable {

	/**
	 * @param id
	 * @param totalAmount
	 * @param date
	 * @param price
	 */
	public InvoiceReceipt(Long totalAmount, LocalDateTime date, Long price) {
		super();
		this.totalAmount = totalAmount;
		this.date = date;
		this.price = price;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_INVOICERECEIPT_ID_GENERATOR")
	@SequenceGenerator(name = "SP_INVOICERECEIPT_ID_GENERATOR", sequenceName = "sp_invoiceReceipt_id_seq", allocationSize = 1)
	private Long id;

	@JsonBackReference
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinColumn(name = "cashierId", referencedColumnName = "id", nullable = false)
	private Cashier cashier;
	@JsonBackReference
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH,
			CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
	private Customer customer;

	@Column(name = "totalAmount", nullable = false)
	private Long totalAmount;

	@DateTimeFormat(pattern = "MM-dd-yyyy HH:mm") // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =
													// "yyyy-MM-dd")//@Temporal(TemporalType.TIMESTAMP)//
	@Column(name = "date")
	private LocalDateTime date;// private Date date;

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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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
		return "InvoiceReceipt [id=" + id + ", cashier=" + cashier.getFirstName() + ", customer="
				+ customer.getFirstName() + ", totalAmount=" + totalAmount + ", date=" + date + ", price=" + price
				+ "]";
	}

}
