package com.supermarket.mapstruct.DTO;

public class VerifyOrderDTO {

	private Long id;

	private EmployeeStaffDTO employeeStaff;

	private OrderProductDTO orderProduct;

	private CustomerDTO customer;

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

	public OrderProductDTO getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProductDTO orderProduct) {
		this.orderProduct = orderProduct;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
}
