package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.Inventory;
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

}
