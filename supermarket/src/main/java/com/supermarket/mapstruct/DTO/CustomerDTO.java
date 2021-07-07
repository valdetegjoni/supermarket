package com.supermarket.mapstruct.DTO;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

public class CustomerDTO {

	// @Id
	// @NotNull
	private Long id;

	@NotNull
	private String firstName;

	@NotNull
	private String lastName;

	@NotNull
	private String address;

	@NotNull
	private Long telephone;

	private String email;

	private Set<OrderProductDTO> orderProducts = new HashSet<>();

	private Set<VerifyOrderDTO> verifyOrders = new HashSet<VerifyOrderDTO>();

	private Set<CashierDTO> cashiers = new HashSet<>();

	private Set<InvoiceReceiptDTO> invoiceReceipts;

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

	public Set<OrderProductDTO> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProductDTO> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Set<VerifyOrderDTO> getVerifyOrders() {
		return verifyOrders;
	}

	public void setVerifyOrders(Set<VerifyOrderDTO> verifyOrders) {
		this.verifyOrders = verifyOrders;
	}

	public Set<CashierDTO> getCashiers() {
		return cashiers;
	}

	public void setCashiers(Set<CashierDTO> cashiers) {
		this.cashiers = cashiers;
	}

	public Set<InvoiceReceiptDTO> getInvoiceReceipts() {
		return invoiceReceipts;
	}

	public void setInvoiceReceipts(Set<InvoiceReceiptDTO> invoiceReceipts) {
		this.invoiceReceipts = invoiceReceipts;
	}

}
