package com.spring.supermarket.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
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
@Table(name = "verifyOrder")
@NamedQuery(name = "VerifyOrder.findAll", query = "from VerifyOrder v")
public class VerifyOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SP_VERIFIEDORDER_ID_GENERATOR")
	@SequenceGenerator(name = "SP_VERIFIEDORDER_ID_GENERATOR", sequenceName = "sp_verifiedOrder_id_seq", allocationSize = 1)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeStaffId")
	private EmployeeStaff employeeStaff;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "orderProductId")
	private OrderProduct orderProduct;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;

	/**
	 * 
	 */
	public VerifyOrder() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeStaff getEmployee() {
		return employeeStaff;
	}

	public void setEmployee(EmployeeStaff employee) {
		this.employeeStaff = employee;
	}

	public OrderProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(OrderProduct orderProduct) {
		this.orderProduct = orderProduct;
	}

	@Override
	public String toString() {
		return "VerifyOrder [id=" + id + ", employeeStaff=" + employeeStaff + ", orderProduct=" + orderProduct + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeStaff, id, orderProduct);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VerifyOrder other = (VerifyOrder) obj;
		return Objects.equals(employeeStaff, other.employeeStaff) && Objects.equals(id, other.id)
				&& Objects.equals(orderProduct, other.orderProduct);
	}

	
}
