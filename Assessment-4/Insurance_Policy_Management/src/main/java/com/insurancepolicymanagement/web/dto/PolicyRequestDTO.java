package com.insurancepolicymanagement.web.dto;

import java.time.LocalDate;

import com.insurancepolicymanagement.web.model.Policy.PolicyType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PolicyRequestDTO {

	@NotBlank(message = "Policy number cannot be blank")
    private String policyNumber;
	@NotNull(message = "Policy type cannot be blank")
    private PolicyType policyType;

	@NotNull(message = "Premium amount cannot be null")
    @Positive(message = "Premium amount must be positive")
    private double premiumAmount;

	@NotNull(message = "Coverage amount cannot be null")
    @Positive(message = "Coverage amount must be positive")
    private double coverageAmount;

	@NotNull(message = "Start date cannot be null")
    private LocalDate startDate;
    private LocalDate endDate;
    
    @NotNull(message = "Customer ID cannot be null")
    private Long customerId;
    
    
    
	public PolicyRequestDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PolicyRequestDTO(@NotBlank(message = "Policy number cannot be blank") String policyNumber,
			@NotNull(message = "Policy type cannot be blank") PolicyType policyType,
			@NotNull(message = "Premium amount cannot be null") @Positive(message = "Premium amount must be positive") double premiumAmount,
			@NotNull(message = "Coverage amount cannot be null") @Positive(message = "Coverage amount must be positive") double coverageAmount,
			@NotNull(message = "Start date cannot be null") LocalDate startDate, LocalDate endDate,
			@NotNull(message = "Customer ID cannot be null") Long customerId) {
		super();
		this.policyNumber = policyNumber;
		this.policyType = policyType;
		this.premiumAmount = premiumAmount;
		this.coverageAmount = coverageAmount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.customerId = customerId;
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
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
    
    
}
