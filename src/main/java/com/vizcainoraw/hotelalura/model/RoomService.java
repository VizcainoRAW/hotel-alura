package com.vizcainoraw.hotelalura.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * RoomService
 */

@Entity
@Table(name = "room_service")
@Data
@NoArgsConstructor
public class RoomService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer RoomServiceId;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
    
}