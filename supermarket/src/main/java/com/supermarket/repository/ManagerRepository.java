package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.Manager;
@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
