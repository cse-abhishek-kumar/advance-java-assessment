package com.insurancepolicymanagement.web.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Policy {

    public enum Status {
        ACTIVE, EXPIRED, CANCELLED
    }

    public enum PolicyType {
        HEALTH, LIFE, VEHICLE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String policyNumber;

    @Enumerated(EnumType.STRING)
    private PolicyType policyType;
    private double premiumAmount;
    private double coverageAmount;
    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Policy() {
    }

    public Policy(String policyNumber, PolicyType policyType, double premiumAmount,
                  double coverageAmount, LocalDate startDate, LocalDate endDate,
                  Status status, Customer customer) {

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}