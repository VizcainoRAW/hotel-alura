package com.vizcainoraw.hotelalura.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ServiceId;

    @Column(nullable = false)
    private String Name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price; 
    
}