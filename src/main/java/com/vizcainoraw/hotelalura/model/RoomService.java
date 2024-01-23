package com.vizcainoraw.hotelalura.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "room_service")
@Data
@NoArgsConstructor
public class RoomService {
    
    @EmbeddedId
    private RoomServiceId id;
}
