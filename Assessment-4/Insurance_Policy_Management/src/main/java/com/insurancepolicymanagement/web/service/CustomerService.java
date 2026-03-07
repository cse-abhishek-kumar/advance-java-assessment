
package com.insurancepolicymanagement.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurancepolicymanagement.web.dto.CustomerRequestDTO;
import com.insurancepolicymanagement.web.dto.CustomerResponseDTO;
import com.insurancepolicymanagement.web.exception.CustomerNotFoundException;
import com.insurancepolicymanagement.web.mapper.CustomerMapper;
import com.insurancepolicymanagement.web.model.Customer;
import com.insurancepolicymanagement.web.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // NO @Autowired CustomerMapper — methods are static, called directly

    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
        if (customerRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Customer already exists with email: " + dto.getEmail());
        }
        Customer customer = CustomerMapper.toEntity(dto);
        Customer saved = customerRepository.save(customer);
        return CustomerMapper.toDTO(saved);
    }

    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerResponseDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return CustomerMapper.toDTO(customer);
    }

    public Customer getCustomerEntityById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }
}