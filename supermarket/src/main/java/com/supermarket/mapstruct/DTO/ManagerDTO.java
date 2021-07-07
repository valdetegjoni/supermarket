package com.supermarket.mapstruct.DTO;

import java.util.Set;

public class ManagerDTO {

	private Long id;

	private String firstName;

	private String lastName;

	private String address;

	private Long telephone;

	private String email;

	private SalesReportDTO salesReportMng;

	private Set<ManageProductDTO> manageProducts;

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

	public SalesReportDTO getSalesReportMng() {
		return salesReportMng;
	}

	public void setSalesReportMng(SalesReportDTO salesReportMng) {
		this.salesReportMng = salesReportMng;
	}

	public Set<ManageProductDTO> getManageProducts() {
		return manageProducts;
	}

	public void setManageProducts(Set<ManageProductDTO> manageProducts) {
		this.manageProducts = manageProducts;
	}

}
