package com.supermarket.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.supermarket.error.EntityNotFoundException;
import com.supermarket.entity.Customer;
import com.supermarket.mapstruct.DTO.CustomerDTO;
import com.supermarket.mapstruct.mapper.CustomerEntityDTOMapper;
import com.supermarket.repository.CustomerRepository;
import com.supermarket.util.MessageUtil;

@Service
public class CustomerService {

	private CustomerRepository customerRepo;

	private CustomerEntityDTOMapper customerMapper;

	private MessageUtil messageUtil;

	/**
	 * @param customerRepo
	 * @param customerMapper
	 * @param message
	 */
	public CustomerService(CustomerRepository customerRepo, CustomerEntityDTOMapper customerMapper,
			MessageUtil message) {
		this.customerRepo = customerRepo;
		this.customerMapper = customerMapper;
		this.messageUtil = message;
	}

	public Customer findCustomerOrThrow(Long id) {
		return customerRepo.findById(id).orElseThrow(() -> new com.supermarket.error.EntityNotFoundException(
				messageUtil.getMessage("customer.NotFound", id)));
	}

	public CustomerDTO getCustomer(Long id) {
		Customer customer = this.findCustomerOrThrow(id);
		return customerMapper.customerToDTO(customer);
	}

	public Page<CustomerDTO> findAllCustomer(Pageable pageable) {
		// Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
		// Pageable secondPageWithFiveElements = PageRequest.of(1, 5);

		Page<Customer> customers = customerRepo.findAll(pageable);// customerRepo.findAll(firstPageWithTwoElements);
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		customers.forEach(customer -> {
			CustomerDTO customerDTO = customerMapper.customerToDTO(customer);
			customerDTOs.add(customerDTO);
		});
		return new PageImpl<>(customerDTOs, pageable, customers.getTotalElements());
	}

	public CustomerDTO create(CustomerDTO customerDTO) {
		Customer customerSave = customerRepo.save(customerMapper.customerDTOToEntity(customerDTO));
		return customerMapper.customerToDTO(customerSave);
	}

	@Transactional
	public void delete(Long id) {
		try {
			customerRepo.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntityNotFoundException(messageUtil.getMessage("customer.NotFound", id));
		}
	}
}
