package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.VerifiedOrder;
@Repository
public interface VerifiedOrderRepository extends JpaRepository<VerifiedOrder, Long>{

}
