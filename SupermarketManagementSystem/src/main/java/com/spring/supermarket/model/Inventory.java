package com.spring.supermarket.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

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
@Table(name = "inventory")
@NamedQuery(name = "inventory.findAll", query = "from Inventory i")
public class Inventory implements Serializable {

	public Set<ManageProduct> getManageProducts() {
		return manageProducts;
	}

	public void setManageProducts(Set<ManageProduct> manageProducts) {
		this.manageProducts = manageProducts;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_INVENTORY_ID_GENERATOR")
	@SequenceGenerator(name = "SP_INVENTORY_ID_GENERATOR", sequenceName = "sp_inventory_id_seq", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "managerId", nullable = false)
	private Manager manager;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contractorId", nullable = false)
	private Contractor contractor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId", nullable = false)
	private Product product;

	@Column(name = "stockIn", nullable = false)
	private Long stockIn;

	@Column(name = "stockOut", nullable = false)
	private Long stockOut;

	@Column(name = "stockRecorded", nullable = false)
	private Long stockRecorded;

	@OneToMany(mappedBy = "inventory")
	private Set<ManageProduct> manageProducts;

	/**
	 * 
	 */
	public Inventory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Contractor getContractor() {
		return contractor;
	}

	public void setContractor(Contractor contractor) {
		this.contractor = contractor;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getStockIn() {
		return stockIn;
	}

	public void setStockIn(Long stockIn) {
		this.stockIn = stockIn;
	}

	public Long getStockOut() {
		return stockOut;
	}

	public void setStockOut(Long stockOut) {
		this.stockOut = stockOut;
	}

	public Long getStockRecorded() {
		return stockRecorded;
	}

	public void setStockRecorded(Long stockRecorded) {
		this.stockRecorded = stockRecorded;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", manager=" + manager + ", contractor=" + contractor + ", product=" + product
				+ ", stockIn=" + stockIn + ", stockOut=" + stockOut + ", stockRecorded=" + stockRecorded
				+ ", manageProducts=" + manageProducts + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contractor, id, manageProducts, manager, product, stockIn, stockOut, stockRecorded);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Inventory other = (Inventory) obj;
		return Objects.equals(contractor, other.contractor) && Objects.equals(id, other.id)
				&& Objects.equals(manageProducts, other.manageProducts) && Objects.equals(manager, other.manager)
				&& Objects.equals(product, other.product) && Objects.equals(stockIn, other.stockIn)
				&& Objects.equals(stockOut, other.stockOut) && Objects.equals(stockRecorded, other.stockRecorded);
	}

}
