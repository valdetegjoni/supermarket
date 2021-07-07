package com.supermarket.entity;

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

@Entity
@Table(name = "manageProduct")
@NamedQuery(name = "ManageProduct.findAll", query = "from ManageProduct mp")
public class ManageProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_MANAGEPRODUCT_ID_GENERATOR")
	@SequenceGenerator(name = "SP_MANAGEPRODUCT_ID_GENERATOR", allocationSize = 1, sequenceName = "sp_manageProduct_id_seq")
	private Long id;

	@Column(name = "totalItemAdd")
	private Long totalItemAdd;

	@Column(name = "totalItemDelete")
	private Long totalItemDelete;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "managerId", nullable = false)
	private Manager manager;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "inventoryId")
	private Inventory inventory;

	public ManageProduct() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalItemAdd() {
		return totalItemAdd;
	}

	public void setTotalItemAdd(Long totalItemAdd) {
		this.totalItemAdd = totalItemAdd;
	}

	public Long getTotalItemDelete() {
		return totalItemDelete;
	}

	public void setTotalItemDelete(Long totalItemDelete) {
		this.totalItemDelete = totalItemDelete;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}
