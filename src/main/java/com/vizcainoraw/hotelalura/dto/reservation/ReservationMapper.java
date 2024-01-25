package com.vizcainoraw.hotelalura.dto.reservation;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.vizcainoraw.hotelalura.model.Reservation;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReservationMapper {

    @Mapping(source = "reservationId", target = "id")
    @Mapping(target = "customerId", source = "customer.customerId")
    @Mapping(target = "customerName", source = "customer.firstName")
    @Mapping(target = "roomId", source = "room.roomId")
    @Mapping(target = "roomNumber", source = "room.roomNumber")
    ReservationDto reservationToDto(Reservation reservation);
    
    @InheritConfiguration
    @Mapping(target = "reservationId", source = "id")
    @Mapping(target = "room", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Reservation DtoToReservation(ReservationDto reservationDto);
}