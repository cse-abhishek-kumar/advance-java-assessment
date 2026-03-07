package com.insurancepolicymanagement.web.mapper;

import com.insurancepolicymanagement.web.dto.CustomerRequestDTO;
import com.insurancepolicymanagement.web.dto.CustomerResponseDTO;
import com.insurancepolicymanagement.web.model.Customer;

public class CustomerMapper {

    public static Customer toEntity(CustomerRequestDTO dto){
        Customer c = new Customer();
        c.setName(dto.getName());
        c.setEmail(dto.getEmail());
        c.setPhoneNumber(dto.getPhoneNumber());
        c.setAddress(dto.getAddress());
        return c;
    }

    public static CustomerResponseDTO toDTO(Customer c){
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setEmail(c.getEmail());
        dto.setPhoneNumber(c.getPhoneNumber());
        dto.setAddress(c.getAddress());
        return dto;
    }
}
