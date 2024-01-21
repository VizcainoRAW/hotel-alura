package com.vizcainoraw.hotelalura.dto.service;

import java.math.BigDecimal;

public record ServiceDto(
    Integer Id,
    String name,
    BigDecimal price
) {}
