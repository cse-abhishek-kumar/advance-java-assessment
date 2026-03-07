package com.insurancepolicymanagement.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurancepolicymanagement.web.dto.PolicyRequestDTO;
import com.insurancepolicymanagement.web.dto.PolicyResponseDTO;
import com.insurancepolicymanagement.web.model.Policy.PolicyType;
import com.insurancepolicymanagement.web.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping
    public ResponseEntity<PolicyResponseDTO> createPolicy(
            @Valid @RequestBody PolicyRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(policyService.createPolicy(dto));
    }

    @GetMapping
    public ResponseEntity<Page<PolicyResponseDTO>> getAllPolicies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        return ResponseEntity.ok(policyService.getAllPolicies(page, size, sortBy, direction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> updatePolicy(
            @PathVariable Long id,
            @Valid @RequestBody PolicyRequestDTO dto) {
        return ResponseEntity.ok(policyService.updatePolicy(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> cancelPolicy(@PathVariable Long id) {
        return ResponseEntity.ok(policyService.cancelPolicy(id));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByType(@PathVariable PolicyType type) {
        return ResponseEntity.ok(policyService.getPoliciesByType(type));
    }

    @GetMapping("/premium")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByPremiumRange(
            @RequestParam double min,
            @RequestParam double max) {
        return ResponseEntity.ok(policyService.getPoliciesByPremiumRange(min, max));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByCustomer(
            @PathVariable Long customerId) {
        return ResponseEntity.ok(policyService.getPoliciesByCustomerId(customerId));
    }

    @GetMapping("/customer/email/{email}")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByCustomerEmail(
            @PathVariable String email) {
        return ResponseEntity.ok(policyService.getPoliciesByCustomerEmail(email));
    }
}
