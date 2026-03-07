package com.insurancepolicymanagement.web.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.insurancepolicymanagement.web.dto.PolicyRequestDTO;
import com.insurancepolicymanagement.web.dto.PolicyResponseDTO;
import com.insurancepolicymanagement.web.exception.PolicyNotFoundException;
import com.insurancepolicymanagement.web.mapper.PolicyMapper;
import com.insurancepolicymanagement.web.model.Customer;
import com.insurancepolicymanagement.web.model.Policy;
import com.insurancepolicymanagement.web.model.Policy.PolicyType;
import com.insurancepolicymanagement.web.model.Policy.Status;
import com.insurancepolicymanagement.web.repository.PolicyRepository;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CustomerService customerService;

    // NO @Autowired PolicyMapper — methods are static, called directly

    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {
        Customer customer = customerService.getCustomerEntityById(dto.getCustomerId());
        Policy policy = PolicyMapper.toEntity(dto, customer);
        Policy saved = policyRepository.save(policy);
        return PolicyMapper.toDTO(saved);
    }

    public Page<PolicyResponseDTO> getAllPolicies(int page, int size, String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return policyRepository.findAll(pageable)
                .map(PolicyMapper::toDTO);
    }

    public PolicyResponseDTO getPolicyById(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException(id));
        return PolicyMapper.toDTO(policy);
    }

    public PolicyResponseDTO updatePolicy(Long id, PolicyRequestDTO dto) {
        Policy existing = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException(id));
        Customer customer = customerService.getCustomerEntityById(dto.getCustomerId());

        existing.setPolicyNumber(dto.getPolicyNumber());
        existing.setPolicyType(dto.getPolicyType());
        existing.setPremiumAmount(dto.getPremiumAmount());
        existing.setCoverageAmount(dto.getCoverageAmount());
        existing.setStartDate(dto.getStartDate());
        existing.setEndDate(dto.getEndDate());
        existing.setCustomer(customer);

        return PolicyMapper.toDTO(policyRepository.save(existing));
    }

    public PolicyResponseDTO cancelPolicy(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException(id));
        policy.setStatus(Status.CANCELLED);
        return PolicyMapper.toDTO(policyRepository.save(policy));
    }

    public List<PolicyResponseDTO> getPoliciesByType(PolicyType type) {
        return policyRepository.findByPolicyType(type)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max) {
        return policyRepository.findByPremiumAmountBetween(min, max)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByCustomerId(Long customerId) {
        return policyRepository.findByCustomerId(customerId)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<PolicyResponseDTO> getPoliciesByCustomerEmail(String email) {
        return policyRepository.findPoliciesByCustomerEmail(email)
                .stream()
                .map(PolicyMapper::toDTO)
                .collect(Collectors.toList());
    }
}