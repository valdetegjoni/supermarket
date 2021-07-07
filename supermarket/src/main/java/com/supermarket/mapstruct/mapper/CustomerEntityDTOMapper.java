package com.supermarket.mapstruct.mapper;

import org.mapstruct.Mapper;

import com.supermarket.entity.Customer;
import com.supermarket.mapstruct.DTO.CustomerDTO;

@Mapper
public interface CustomerEntityDTOMapper {

	CustomerDTO customerToDTO(Customer customer);

	Customer customerDTOToEntity(CustomerDTO customerDTO);
}
