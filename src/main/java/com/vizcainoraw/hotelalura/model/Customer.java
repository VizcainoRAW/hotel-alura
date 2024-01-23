package com.vizcainoraw.hotelalura.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Customer
 */

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String phoneNumber;

}