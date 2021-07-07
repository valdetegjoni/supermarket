package com.supermarket.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.mapstruct.DTO.InvoiceReceiptDTO;
import com.supermarket.service.InvoiceReceiptService;

@RestController
@RequestMapping("/invoice")
public class InvoiceReceiptController {

	private InvoiceReceiptService invoiceService;

	/**
	 * @param invoiceService
	 */
	public InvoiceReceiptController(InvoiceReceiptService invoiceService) {
		this.invoiceService = invoiceService;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public InvoiceReceiptDTO getInvoiceReceipt(@PathVariable Long id) {
		return invoiceService.getInvoiceReceipt(id);
	}

	@GetMapping
	@ResponseBody
	public Page<InvoiceReceiptDTO> getAllInvoiceReceipt(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return invoiceService.findAllInvoiceReceipt(pageable);
	}

}
