package com.vizcainoraw.hotelalura.model;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ReservationId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer Customer;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room Room;

    @Column(nullable = false)
    private Date StartDate;

    @Column(nullable = false)
    private Date EndDate;


}