package com.vizcainoraw.hotelalura.dto.employee;

import java.math.BigDecimal;

public record EmployeeDto(
    Long id,
    String firstName,
    String lastName,
    BigDecimal salary
) {}