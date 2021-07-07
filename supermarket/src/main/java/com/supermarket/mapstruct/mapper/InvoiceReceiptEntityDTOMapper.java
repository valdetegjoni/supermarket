package com.supermarket.mapstruct.mapper;

import org.mapstruct.Mapper;

import com.supermarket.entity.InvoiceReceipt;
import com.supermarket.mapstruct.DTO.InvoiceReceiptDTO;

@Mapper
public interface InvoiceReceiptEntityDTOMapper {

	InvoiceReceiptDTO invoiceReceiptTODTO(InvoiceReceipt invoiceReceipt);

	InvoiceReceipt invoiceReceiptDTOToEntity(InvoiceReceiptDTO invoiceReceiptDTO);
}
