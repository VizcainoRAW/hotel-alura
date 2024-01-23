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
public class RoomServiceId implements Serializable {

    @Column(name = "room_id")
    private Integer roomId;

    @Column(name = "service_id")
    private Integer serviceId;

}