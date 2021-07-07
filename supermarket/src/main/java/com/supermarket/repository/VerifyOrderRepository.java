package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.VerifyOrder;
@Repository
public interface VerifyOrderRepository extends JpaRepository<VerifyOrder, Long>{

}
