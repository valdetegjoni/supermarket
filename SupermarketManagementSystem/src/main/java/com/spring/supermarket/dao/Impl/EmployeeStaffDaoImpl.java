package com.spring.supermarket.dao.Impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.spring.supermarket.dao.EmployeeStaffDao;
import com.spring.supermarket.model.EmployeeStaff;

@Repository
public class EmployeeStaffDaoImpl implements EmployeeStaffDao {

	private SessionFactory session;

	/**
	 * @param session
	 */
	public EmployeeStaffDaoImpl(SessionFactory session) {
		this.session = session;
	}

	/**
	 * 
	 */
	public EmployeeStaffDaoImpl() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<EmployeeStaff> findByCashier(Long id) {

		List<EmployeeStaff> employeeStaffList = session.getCurrentSession()
				.createQuery("from employeeStaff e join e.submitProduct s where s.cashierId = :id")
				.setString("id", "%" + id + "%").list();
		Set<EmployeeStaff> employeeStaffs = new HashSet<>(employeeStaffList);
		return employeeStaffs;
	}

}
