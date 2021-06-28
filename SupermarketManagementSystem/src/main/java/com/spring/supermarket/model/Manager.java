package com.spring.supermarket.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "manager")
@NamedQuery(name = "manager.findAll", query = " from Manager m")
public class Manager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_MANAGER_ID_GENERATOR")
	@SequenceGenerator(name = "SP_MANAGER_ID_GENERATOR", sequenceName = "sp_manager_id_seq", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "firstName", nullable = false, length = 255)
	private String firstName;

	@Column(name = "lastName", nullable = false, length = 255)
	private String lastName;

	@Column(nullable = false, length = 255)
	private String address;

	@Column(nullable = false)
	private Long telephone;

	@Column(length = 50)
	private String email;

	@OneToOne(optional = false)
	@JoinColumn(name = "id")
	private SalesReport salesReportMng;

	@OneToMany(mappedBy = "manager")
	private Set<ManageProduct> manageProducts;

	/**
	 * 
	 */
	public Manager() {
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

	@Override
	public String toString() {
		return "Manager [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", telephone=" + telephone + ", email=" + email + ", salesReportMng=" + salesReportMng
				+ ", manageProducts=" + manageProducts + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, firstName, id, lastName, manageProducts, salesReportMng, telephone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(manageProducts, other.manageProducts)
				&& Objects.equals(salesReportMng, other.salesReportMng) && Objects.equals(telephone, other.telephone);
	}
}
