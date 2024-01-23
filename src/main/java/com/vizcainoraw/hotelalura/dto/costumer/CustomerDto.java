package com.vizcainoraw.hotelalura.dto.costumer;

/**
 * CustomerDto
 */
public record CustomerDto(
    Long id,
    String email,
    String firstName,
    String lastName,
    String phoneNumber
) {}