package com.project.insurance.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Client {

    @Id
    @Column(name="clientId")
    private int clientId;

    @Column(name="clientName")
    private String clientName;

    @Column(name="clientDateOfBirth")
    private String clientDateOfBirth;

    @Column(name="clientAddress")
    private String clientAddress;

    @Column(name="clientContactInformation")
    private long clientContactInformation;

    @ManyToOne
    @JoinColumn(name="policyId")
    private InsurancePolicy insurancePolicy;
}
