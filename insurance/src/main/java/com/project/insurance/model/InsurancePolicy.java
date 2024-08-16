package com.project.insurance.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="insurancePolicy")
public class InsurancePolicy {
    @Column(name="policyId")
    @Id
    private int insurancePolicyId;

    @Column(name="policyNumber")
    private String insurancePolicyNumber;

    @Column(name="policyType")
    private String insurancePolicyType;

    @Column(name="policyCoverageAmount")
    private String insurancePolicyCoverageAmount;

    @Column(name="policyPremium")
    private String insurancePolicyPremium;

    @Column(name="policyStartDate")
    private String insurancePolicyStartDate;

    @Column(name="policyEndDate")
    private String insurancePolicyEndDate;
}
