package com.supermarket.mapstruct.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CashierDTO {

	private Long id;

	private String firstName;

	private String lastName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthdate;

	private String address;

	private Long telephone;

	private String email;

	private Set<CustomerDTO> customers = new HashSet<>();

	private Set<EmployeeStaffDTO> employeeStaffs = new HashSet<>();

	private Set<InvoiceReceiptDTO> invoiceReceipts;

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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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

	public Set<CustomerDTO> getCustomersDTO() {
		return customers;
	}

	public void setCustomersDTO(Set<CustomerDTO> customers) {
		this.customers = customers;
	}

	public Set<EmployeeStaffDTO> getEmployeeStaffDTOs() {
		return employeeStaffs;
	}

	public void setEmployeeStaffDTOs(Set<EmployeeStaffDTO> employeeStaffs) {
		this.employeeStaffs = employeeStaffs;
	}

	public Set<InvoiceReceiptDTO> getInvoiceReceipts() {
		return invoiceReceipts;
	}

	public void setInvoiceReceiptDTOs(Set<InvoiceReceiptDTO> invoiceReceipts) {
		this.invoiceReceipts = invoiceReceipts;
	}

}
