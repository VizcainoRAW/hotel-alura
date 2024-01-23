package com.vizcainoraw.hotelalura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.errors.ResourceNotFoundException;

import com.vizcainoraw.hotelalura.model.Service;
import com.vizcainoraw.hotelalura.dto.service.ServiceDto;
import com.vizcainoraw.hotelalura.dto.service.ServiceMapper;
import com.vizcainoraw.hotelalura.repository.ServiceRepository;

import lombok.NonNull;

@org.springframework.stereotype.Service
public class ServiceService {

    private final ServiceRepository repository;
    private final ServiceMapper mapper;

    public ServiceService(ServiceRepository repository, ServiceMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<ServiceDto> findAllServices(){
        return repository.findAll().stream()
        .map(service -> mapper.serviceToDto(service))
        .collect(Collectors.toList());
    }

    public ServiceDto findServiceById(@NonNull Integer id){
        return repository.findById(id)
        .map(service -> mapper.serviceToDto(service))
        .orElseThrow(() -> new ResourceNotFoundException(
            "no found service with id (%s)".formatted(id
            )));
    }

    public ServiceDto createService(@NonNull ServiceDto serviceDto){
        Service service = mapper.ServiceDtoToEntity(serviceDto);
        if (service == null) {
            throw new IllegalArgumentException("Cannot convert ServiceDto to Service");
        }

        return mapper.serviceToDto(
            repository.save(service)
            );
    }

    public ServiceDto updateService(@NonNull Integer id, ServiceDto updatedServiceDto){
        // check if service to update exits
        Service service = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(
                "no found service with id(%s)".formatted(id)
                ));

        // update and save
        service.setName(updatedServiceDto.name());
        service.setCost(updatedServiceDto.cost());

        return mapper.serviceToDto(
            repository.save(service)
            );
    }

    public void deleteService(@NonNull Integer id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(
                String.format("No found service id (%d) to delete", id));
        }
        repository.deleteById(id);
    }
}