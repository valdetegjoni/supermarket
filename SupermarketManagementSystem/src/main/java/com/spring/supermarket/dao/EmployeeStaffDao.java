package com.spring.supermarket.dao;

import java.util.Set;

import com.spring.supermarket.model.EmployeeStaff;

public interface EmployeeStaffDao {

	public Set<EmployeeStaff> findByCashier(Long id);

}
