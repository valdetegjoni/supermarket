package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.ManageProduct;
@Repository
public interface ManageProductRepository extends JpaRepository<ManageProduct, Long>{

}
