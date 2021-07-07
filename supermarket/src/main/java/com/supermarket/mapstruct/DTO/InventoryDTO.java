package com.supermarket.mapstruct.DTO;

import java.util.Set;

public class InventoryDTO {

	private Long id;

	private ManagerDTO manager;

	private ContractorDTO contractor;

	private ProductDTO product;

	private Long stockIn;

	private Long stockOut;

	private Long stockRecorded;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ManagerDTO getManagerDTO() {
		return manager;
	}

	public void setManagerDTO(ManagerDTO manager) {
		this.manager = manager;
	}

	public ContractorDTO getContractorDTO() {
		return contractor;
	}

	public void setContractorDTO(ContractorDTO contractor) {
		this.contractor = contractor;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProductDTO(ProductDTO product) {
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

	public Set<ManageProductDTO> getManageProducts() {
		return manageProducts;
	}

	public void setManageProducts(Set<ManageProductDTO> manageProducts) {
		this.manageProducts = manageProducts;
	}

	private Set<ManageProductDTO> manageProducts;

}
