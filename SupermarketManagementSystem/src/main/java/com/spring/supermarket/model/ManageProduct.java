package com.spring.supermarket.model;

import java.io.Serializable;
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

@Entity
@Table(name = "manageProduct")
@NamedQuery(name = "ManageProduct.findAll", query = "from ManageProduct mp")
public class ManageProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	@Override
	public String toString() {
		return "ManageProduct [id=" + id + ", totalItemAdd=" + totalItemAdd + ", totalItemDelete=" + totalItemDelete
				+ ", manager=" + manager + ", inventory=" + inventory + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, inventory, manager, totalItemAdd, totalItemDelete);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManageProduct other = (ManageProduct) obj;
		return Objects.equals(id, other.id) && Objects.equals(inventory, other.inventory)
				&& Objects.equals(manager, other.manager) && Objects.equals(totalItemAdd, other.totalItemAdd)
				&& Objects.equals(totalItemDelete, other.totalItemDelete);
	}

}
