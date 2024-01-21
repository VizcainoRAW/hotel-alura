package com.vizcainoraw.hotelalura.dto.service;

import java.util.function.Function;

import com.vizcainoraw.hotelalura.model.Service;

public class ServiceMapper implements Function<Service, ServiceDto>{
     
    @Override
    public ServiceDto apply(Service service) {
        return new ServiceDto(
            service.getServiceId(),
            service.getName(),
            service.getPrice()
        );
    }
}
