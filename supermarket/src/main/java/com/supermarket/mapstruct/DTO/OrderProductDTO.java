package com.supermarket.mapstruct.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderProductDTO {

	private Long id;

	private CustomerDTO customer;

	private ProductDTO product;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;

	private String details;

	private Long quantity;

	private Set<VerifyOrderDTO> verifyOrders = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
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

	public Set<VerifyOrderDTO> getVerifyOrders() {
		return verifyOrders;
	}

	public void setVerifyOrders(Set<VerifyOrderDTO> verifyOrders) {
		this.verifyOrders = verifyOrders;
	}
}
