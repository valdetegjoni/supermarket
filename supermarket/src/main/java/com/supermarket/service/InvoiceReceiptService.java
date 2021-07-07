package com.supermarket.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.supermarket.entity.InvoiceReceipt;
import com.supermarket.mapstruct.DTO.InvoiceReceiptDTO;
import com.supermarket.mapstruct.mapper.InvoiceReceiptEntityDTOMapper;
import com.supermarket.repository.InvoiceReceiptRepository;
import com.supermarket.util.MessageUtil;

@Service
public class InvoiceReceiptService {

	private InvoiceReceiptRepository invoiceReceiptRepo;

	private InvoiceReceiptEntityDTOMapper invoiceReceiptMapper;

	private MessageUtil messageUtil;

	/**
	 * @param invoiceReceiptRepo
	 * @param invoiceReceiptMapper
	 * @param messageUtil
	 */
	public InvoiceReceiptService(InvoiceReceiptRepository invoiceReceiptRepo,
			InvoiceReceiptEntityDTOMapper invoiceReceiptMapper, MessageUtil messageUtil) {
		this.invoiceReceiptRepo = invoiceReceiptRepo;
		this.invoiceReceiptMapper = invoiceReceiptMapper;
		this.messageUtil = messageUtil;
	}

	public InvoiceReceipt findInvoiceReceiptOrThrow(Long id) {
		return invoiceReceiptRepo.findById(id).orElseThrow(() -> new com.supermarket.error.EntityNotFoundException(
				messageUtil.getMessage("invoiceReceipt.NotFound", id)));
	}

	public InvoiceReceiptDTO getInvoiceReceipt(Long id) {
		InvoiceReceipt invoiceReceipt = this.findInvoiceReceiptOrThrow(id);
		return invoiceReceiptMapper.invoiceReceiptTODTO(invoiceReceipt);
	}

	public Page<InvoiceReceiptDTO> findAllInvoiceReceipt(Pageable pageable) {

		Page<InvoiceReceipt> invoiceReceipts = invoiceReceiptRepo.findAll(pageable);
		List<InvoiceReceiptDTO> invoiceReceiptDTOs = new ArrayList<>();
		invoiceReceipts.forEach(invoiceReceipt -> {
			InvoiceReceiptDTO invoiceReceiptDTO = invoiceReceiptMapper.invoiceReceiptTODTO(invoiceReceipt);
			invoiceReceiptDTOs.add(invoiceReceiptDTO);
		});
		return new PageImpl<>(invoiceReceiptDTOs, pageable, invoiceReceipts.getTotalElements());
	}
}
