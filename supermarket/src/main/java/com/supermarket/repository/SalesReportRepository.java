package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.SalesReport;
@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long>{

}
