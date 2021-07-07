package com.supermarket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "contractor")
@NamedQuery(name = "contractor.findAll", query = " from Contractor co")
public class Contractor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_CONTRACTOR_ID_GENERATOR")
	@SequenceGenerator(name = "SP_CONTRACTOR_ID_GENERATOR", sequenceName = "sp_contractor_id_seq", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "companyName", nullable = false, length = 255)
	private String companyName;

	@Column(name = "address", nullable = false, length = 255)
	private String address;

	@Column(nullable = false)
	private Long telephone;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "managerId", nullable = false)
	private Manager manager;

	/**
	 * 
	 */
	public Contractor() {
	}

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

	public void setTelephone(Long phone) {
		this.telephone = phone;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
