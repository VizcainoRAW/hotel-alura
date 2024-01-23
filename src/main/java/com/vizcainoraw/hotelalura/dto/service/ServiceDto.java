package com.vizcainoraw.hotelalura.dto.service;

import java.math.BigDecimal;

public record ServiceDto(
    Long id,
    String name,
    BigDecimal cost
) {}
