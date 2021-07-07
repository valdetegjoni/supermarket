package com.supermarket.mapstruct.DTO;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SalesReportDTO {

	private Long id;

	private EmployeeStaffDTO employeeStaff;

	private ManagerDTO manager;

	private String salesReportDescription;

	private Long salesQuantity;

	private Long totalAmount;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateReport;

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

	public ManagerDTO getManager() {
		return manager;
	}

	public void setManager(ManagerDTO manager) {
		this.manager = manager;
	}

	public String getSalesReportDescription() {
		return salesReportDescription;
	}

	public void setSalesReportDescription(String salesReportDescription) {
		this.salesReportDescription = salesReportDescription;
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
