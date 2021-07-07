package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.EmployeeStaff;
@Repository
public interface EmployeeStaffRepository extends JpaRepository<EmployeeStaff, Long>{

}
