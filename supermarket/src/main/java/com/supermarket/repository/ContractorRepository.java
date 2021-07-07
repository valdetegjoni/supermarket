package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.Contractor;
@Repository
public interface ContractorRepository extends JpaRepository<Contractor, Long>{
}
