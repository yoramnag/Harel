package com.example.harel.entity;

import com.example.harel.dto.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "policies", uniqueConstraints = @UniqueConstraint(columnNames = "policy_number"))
@JsonIgnoreProperties(ignoreUnknown = true)
public class Policies {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customers customer;

    @Column(name="policy_number", nullable = false)
    @NotEmpty(message = "policy_number can Not be null or empty")
    @Min(value = 0 , message = "policy_number need to be greater then 0")
    private String policyNumber;

    @Column(name="premium")
    @DecimalMin(value = "1.0", message = "premium should be greater than 1")
    private double premium;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;


}
