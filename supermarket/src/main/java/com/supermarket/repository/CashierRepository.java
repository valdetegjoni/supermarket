package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.Cashier;

@Repository
public interface CashierRepository extends JpaRepository<Cashier, Long>{

}
