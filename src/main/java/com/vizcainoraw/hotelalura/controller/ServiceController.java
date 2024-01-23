package com.vizcainoraw.hotelalura.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vizcainoraw.hotelalura.dto.service.ServiceDto;
import com.vizcainoraw.hotelalura.service.ServiceService;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class ServiceController {

    private final ServiceService service;

    public ServiceController(ServiceService service){
        this.service = service;
    }
    
    @GetMapping("/services")
    public ResponseEntity<Iterable<ServiceDto>> getAllServices() {
        return ResponseEntity.ok(service.findAllServices());
    }

    @GetMapping("/service/{id}")
    public ResponseEntity<ServiceDto> getServiceById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findServiceById(id));
    }

    @PostMapping("/service")
    public ResponseEntity<ServiceDto> createService(@RequestBody ServiceDto serviceDto) {
        ServiceDto createdServiceDto = service.createService(serviceDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(createdServiceDto.id())
        .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/service/{id}")
    public ResponseEntity<ServiceDto> putService(@PathVariable Integer id, @RequestBody ServiceDto updatedServiceDto) {
        return ResponseEntity.ok(
            service.updateService(id, updatedServiceDto)
        );
    }

    @DeleteMapping("/service/{id}")
    public ResponseEntity<?> deleteService(@PathVariable Integer id){
        service.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}