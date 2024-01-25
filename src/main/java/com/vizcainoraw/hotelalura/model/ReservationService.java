package com.vizcainoraw.hotelalura.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation_services")
@Data
@NoArgsConstructor
public class ReservationService {
    
    @EmbeddedId
    private ReservationServiceId id;
}