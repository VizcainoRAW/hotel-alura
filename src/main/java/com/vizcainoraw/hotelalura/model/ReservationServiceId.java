package com.vizcainoraw.hotelalura.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * RoomService
 */

@Embeddable
@Data
@NoArgsConstructor
public class ReservationServiceId implements Serializable {

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "service_id")
    private Long reservationId;

}