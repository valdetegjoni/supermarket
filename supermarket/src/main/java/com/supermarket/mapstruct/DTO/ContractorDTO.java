package com.supermarket.mapstruct.DTO;


public class ContractorDTO {

	private Long id;

	private String companyName;

	private String address;

	private Long telephone;

	private ManagerDTO manager;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public ManagerDTO getManagerDTO() {
		return manager;
	}

	public void setManagerDTO(ManagerDTO manager) {
		this.manager = manager;
	}

}
