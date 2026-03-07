package com.insurancepolicymanagement.web.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurancepolicymanagement.web.model.Policy;
import com.insurancepolicymanagement.web.model.Policy.PolicyType;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findByPolicyType(PolicyType policyType);

    List<Policy> findByCustomerId(Long customerId);

    List<Policy> findByPremiumAmountBetween(double min, double max);

    @Query("SELECT p FROM Policy p WHERE p.customer.email = :email")
    List<Policy> findPoliciesByCustomerEmail(String email);
    
    Page<Policy> findAll(Pageable pageable);
}