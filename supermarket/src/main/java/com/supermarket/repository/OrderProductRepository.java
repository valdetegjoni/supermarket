package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.OrderProduct;
@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long>{

}
