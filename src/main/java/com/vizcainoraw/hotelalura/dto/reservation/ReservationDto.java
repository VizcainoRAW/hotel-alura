package com.vizcainoraw.hotelalura.dto.reservation;

import java.sql.Date;

public record ReservationDto(
    Long id,
    Long customerId,
    String customerName,
    Long roomId,
    Integer roomNumber,
    Date startDate,
    Date endDate
) {}