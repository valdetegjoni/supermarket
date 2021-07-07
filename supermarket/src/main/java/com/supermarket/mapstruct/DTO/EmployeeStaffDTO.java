package com.supermarket.mapstruct.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.supermarket.entity.Cashier;
import com.supermarket.entity.SalesReport;
import com.supermarket.entity.VerifiedOrder;
import com.supermarket.entity.VerifyOrder;

public class EmployeeStaffDTO {

	private Long id;

	private String firstName;

	private String lastName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthdate;

	private String address;

	private Long telephone;

	private String email;

	private String userName;

	private String password;

	private Set<VerifyOrder> verifyOrders = new HashSet<>();

	private Set<VerifiedOrder> verifiedOrders = new HashSet<>();

	private Set<Cashier> cashiers = new HashSet<>();

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<VerifyOrder> getVerifyOrders() {
		return verifyOrders;
	}

	public void setVerifyOrders(Set<VerifyOrder> verifyOrders) {
		this.verifyOrders = verifyOrders;
	}

	public Set<VerifiedOrder> getVerifiedOrders() {
		return verifiedOrders;
	}

	public void setVerifiedOrders(Set<VerifiedOrder> verifiedOrders) {
		this.verifiedOrders = verifiedOrders;
	}

	public Set<Cashier> getCashiers() {
		return cashiers;
	}

	public void setCashiers(Set<Cashier> cashiers) {
		this.cashiers = cashiers;
	}

	public SalesReport getSalesReportEmp() {
		return salesReportEmp;
	}

	public void setSalesReportEmp(SalesReport salesReportEmp) {
		this.salesReportEmp = salesReportEmp;
	}

	private SalesReport salesReportEmp;
}
