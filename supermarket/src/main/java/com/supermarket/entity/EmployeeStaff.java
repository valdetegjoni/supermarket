package com.supermarket.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employeeStaff")
@NamedQuery(name = "employeeStaff.findAll", query = "from EmployeeStaff e")
public class EmployeeStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_EMPLOYEESTAFF_ID_GENERATOR")
	@SequenceGenerator(name = "SP_EMPLOYEESTAFF_ID_GENERATOR", sequenceName = "sp_employeeStaff_id_seq", allocationSize = 1)

	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(nullable = false, length = 255)
	private String firstName;

	@Column(nullable = false, length = 255)
	private String lastName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthdate")
	private Date birthdate;

	@Column(nullable = false, length = 255)
	private String address;

	@Column(nullable = false)
	private Long telephone;

	@Column(length = 50)
	private String email;

	@Column(name = "userName", length = 255)
	private String userName;

	@Column(name = "password", length = 255)
	private String password;

	@OneToMany(mappedBy = "employeeStaff")
	Set<VerifyOrder> verifyOrders = new HashSet<>();

	@OneToMany(mappedBy = "employeeStaff")
	Set<VerifiedOrder> verifiedOrders = new HashSet<>();

	@ManyToMany(mappedBy = "employeeStaffs")
	private Set<Cashier> cashiers = new HashSet<>();

	@OneToOne(optional = false)
	@JoinColumn(name = "id")
	private SalesReport salesReportEmp;

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

	public Set<VerifyOrder> getVerifyOrders() {
		return verifyOrders;
	}

	public void setVerifyOrders(Set<VerifyOrder> verifyOrders) {
		this.verifyOrders = verifyOrders;
	}

	/**
	 * 
	 */
	public EmployeeStaff() {
	}

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

}
