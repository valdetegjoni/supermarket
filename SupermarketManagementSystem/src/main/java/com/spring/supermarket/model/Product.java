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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@NamedQuery(name = "product.findAll", query = " FROM Product p")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_PRODUCT_ID_GENERATOR")
	@SequenceGenerator(name = "SP_PRODUCT_ID_GENERATOR", sequenceName = "sp_product_id_seq", allocationSize = 1)

	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "productName", nullable = false, length = 255)
	private String productName;

	@Column(name = "productDescription", length = 255)
	private String productDescription;

	@Column(name = "productPrice", nullable = false)
	private Double productPrice;

	@Column(name = "productQuantity", nullable = false)
	private Long productQuantity;

	@Column(name = "productIn", nullable = false)
	private Long productIn;

	@Column(name = "productOut", nullable = false)
	private Long productOut;

	@Column(name = "category", length = 255)
	private String category;

	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	Set<OrderProduct> orderProducts = new HashSet<>();

	public Set<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(Set<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	/**
	 * 
	 */
	public Product() {
	}

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

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", productIn=" + productIn
				+ ", productOut=" + productOut + ", category=" + category + ", orderProducts=" + orderProducts + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, id, orderProducts, productDescription, productIn, productName, productOut,
				productPrice, productQuantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && Objects.equals(id, other.id)
				&& Objects.equals(orderProducts, other.orderProducts)
				&& Objects.equals(productDescription, other.productDescription)
				&& Objects.equals(productIn, other.productIn) && Objects.equals(productName, other.productName)
				&& Objects.equals(productOut, other.productOut) && Objects.equals(productPrice, other.productPrice)
				&& Objects.equals(productQuantity, other.productQuantity);
	}

}
