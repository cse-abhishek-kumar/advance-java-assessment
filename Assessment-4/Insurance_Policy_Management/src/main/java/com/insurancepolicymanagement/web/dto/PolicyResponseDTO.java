package com.insurancepolicymanagement.web.dto;

import java.time.LocalDate;

import com.insurancepolicymanagement.web.model.Policy;
import com.insurancepolicymanagement.web.model.Policy.PolicyType;
import com.insurancepolicymanagement.web.model.Policy.Status;

public class PolicyResponseDTO {

    private Long id;
    private String policyNumber;
    private PolicyType policyType;
    private double premiumAmount;
    private double coverageAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;

    private CustomerResponseDTO customer;
    
    

	public PolicyResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public PolicyResponseDTO(Long id, String policyNumber, PolicyType policyType, double premiumAmount,
			double coverageAmount, LocalDate startDate, LocalDate endDate, Status status,
			CustomerResponseDTO customer) {
		super();
		this.id = id;
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.customer = customer;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public PolicyType getPolicyType() {
		return policyType;
	}

	public void setPolicyType(PolicyType policyType) {
		this.policyType = policyType;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public CustomerResponseDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerResponseDTO customer) {
		this.customer = customer;
	}
    
    
}
