package com.insurancepolicymanagement.web.mapper;

import com.insurancepolicymanagement.web.dto.CustomerResponseDTO;
import com.insurancepolicymanagement.web.dto.PolicyRequestDTO;
import com.insurancepolicymanagement.web.dto.PolicyResponseDTO;
import com.insurancepolicymanagement.web.model.Customer;
import com.insurancepolicymanagement.web.model.Policy;
import com.insurancepolicymanagement.web.model.Policy.Status;

public class PolicyMapper {
	
	public static Policy toEntity(PolicyRequestDTO dto, Customer customer) {
        Policy policy = new Policy();
        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());
        policy.setStatus(Status.ACTIVE);
        policy.setCustomer(customer);
        return policy;
    }

    public static PolicyResponseDTO toDTO(Policy p){

        PolicyResponseDTO dto = new PolicyResponseDTO();

        dto.setId(p.getId());
        dto.setPolicyNumber(p.getPolicyNumber());
        dto.setPolicyType(p.getPolicyType());
        dto.setPremiumAmount(p.getPremiumAmount());
        dto.setCoverageAmount(p.getCoverageAmount());
        dto.setStartDate(p.getStartDate());
        dto.setEndDate(p.getEndDate());
        dto.setStatus(p.getStatus());

        CustomerResponseDTO customerDTO = CustomerMapper.toDTO(p.getCustomer());

        dto.setCustomer(customerDTO);

        return dto;
    }
}
