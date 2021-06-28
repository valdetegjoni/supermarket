package com.spring.supermarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.supermarket.model.Customer;
import com.spring.supermarket.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	/**
	 * @param customerService
	 */
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * 
	 */
	public CustomerController() {
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", this.customerService.findAll());
		return "customer";
	}

}
