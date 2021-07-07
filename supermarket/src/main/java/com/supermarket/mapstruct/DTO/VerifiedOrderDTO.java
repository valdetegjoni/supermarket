package com.supermarket.mapstruct.DTO;

public class VerifiedOrderDTO {

	private Long id;

	private EmployeeStaffDTO employeeStaff;

	private CustomerDTO customer;

	private VerifyOrderDTO verifyOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeStaffDTO getEmployeeStaff() {
		return employeeStaff;
	}

	public void setEmployeeStaff(EmployeeStaffDTO employeeStaff) {
		this.employeeStaff = employeeStaff;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public VerifyOrderDTO getVerifyOrder() {
		return verifyOrder;
	}

	public void setVerifyOrder(VerifyOrderDTO verifyOrder) {
		this.verifyOrder = verifyOrder;
	}
}
