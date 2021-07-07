package com.supermarket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "salesReport")
@NamedQuery(name = "SalesReport.findAll", query = " from SalesReport sr")
public class SalesReport {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_SALESREPORT_ID_GENERATOR")
	@SequenceGenerator(name = "SP_SALESREPORT_ID_GENERATOR", allocationSize = 1, sequenceName = "sp_salesReport_id_seq")
	private Long id;

	@OneToOne(mappedBy = "salesReportEmp")
	@JoinColumn(name = "employeeStaffId")
	private EmployeeStaff employeeStaff;

	@OneToOne(mappedBy = "salesReportMng")
	@JoinColumn(name = "managerId")
	private Manager manager;

	@Column(name = "salesReportDescription", length = 255)
	private String salesReportDescription;

	@Column(name = "salesQuantity")
	private Long salesQuantity;

	@Column(name = "totalAmount")
	private Long totalAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dateReport")
	private Date dateReport;

	/**
	 * 
	 */
	public SalesReport() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeStaff getEmployeeStaff() {
		return employeeStaff;
	}

	public void setEmployeeStaff(EmployeeStaff employeeStaff) {
		this.employeeStaff = employeeStaff;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getSalesReportDescription() {
		return salesReportDescription;
	}

	public void setSalesReportDescription(String salesDescription) {
		this.salesReportDescription = salesDescription;
	}

	public Long getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(Long salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDateReport() {
		return dateReport;
	}

	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}

}
