package com.supermarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supermarket.entity.InvoiceReceipt;
@Repository
public interface InvoiceReceiptRepository extends JpaRepository<InvoiceReceipt, Long>{

}
