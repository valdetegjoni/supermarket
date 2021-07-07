package com.supermarket.mapstruct.DTO;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {

	private Long id;

	private String productName;

	private String productDescription;

	private Double productPrice;

	private Long productQuantity;

	private Long productIn;

	private Long productOut;

	private String category;

	private Set<OrderProductDTO> orderProducts = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Long getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Long getProductIn() {
		return productIn;
	}

	public void setProductIn(Long productIn) {
		this.productIn = productIn;
	}

	public Long getProductOut() {
		return productOut;
	}

	public void setProductOut(Long productOut) {
		this.productOut = productOut;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Set<OrderProductDTO> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProductDTO> orderProducts) {
		this.orderProducts = orderProducts;
	}

}
