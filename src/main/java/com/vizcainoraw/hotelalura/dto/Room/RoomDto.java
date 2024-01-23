package com.vizcainoraw.hotelalura.dto.Room;

import java.math.BigDecimal;

public record RoomDto(
    Long id,
    Integer number,
    String type,
    BigDecimal price,
    boolean Occupied
) {}