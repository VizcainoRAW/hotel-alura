package com.vizcainoraw.hotelalura.dto.service;

import java.math.BigDecimal;

public record ServiceDto(
    Integer id,
    String name,
    BigDecimal cost
) {}
