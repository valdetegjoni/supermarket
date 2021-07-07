package com.supermarket.controller;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supermarket.mapstruct.DTO.CustomerDTO;
import com.supermarket.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService customerService;

	/**
	 * @param customerService
	 */
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@GetMapping("/{id}")
	@ResponseBody
	public CustomerDTO getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
	}

	@GetMapping
	@ResponseBody
	// public Page<CustomerDTO> getAllCustomer(@PageableDefault(sort = "firstName",
	// direction = Sort.Direction.ASC) Pageable pageable) {
	public Page<CustomerDTO> getAllCustomer(
			@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		return customerService.findAllCustomer(pageable);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public CustomerDTO create(@RequestBody @Valid CustomerDTO req) {
		return customerService.create(req);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Long id) {
		customerService.delete(id);
	}

}
