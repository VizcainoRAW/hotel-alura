package com.vizcainoraw.hotelalura.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
public class Room {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer RoomId;

    @Column(nullable = false)
    private Integer RoomNumber;

    @Column(nullable = false)
    private String Type;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal Price;

    @Column(nullable = true)
    private Boolean Occupied; 
}