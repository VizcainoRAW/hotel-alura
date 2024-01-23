package com.vizcainoraw.hotelalura.dto.service;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.vizcainoraw.hotelalura.model.Service;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ServiceMapper{
     
    @Mapping(source = "serviceId", target = "id" )
    ServiceDto serviceToDto(Service service);

    @InheritInverseConfiguration
    Service ServiceDtoToEntity(ServiceDto serviceDto);

}
