package com.supermarket.mapstruct.DTO;

public class ManageProductDTO {

	private Long id;

	private Long totalItemAdd;

	private Long totalItemDelete;

	private ManagerDTO manager;

	private InventoryDTO inventory;

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

	public ManagerDTO getManager() {
		return manager;
	}

	public void setManager(ManagerDTO manager) {
		this.manager = manager;
	}

	public InventoryDTO getInventory() {
		return inventory;
	}

	public void setInventory(InventoryDTO inventory) {
		this.inventory = inventory;
	}
}
