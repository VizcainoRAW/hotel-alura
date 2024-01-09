package com.vizcainoraw.hotelalura.service;

import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.repository.ServiceRepository;

@Service
public class ServiceService {

    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository){
        this.repository = repository;
    }

    public Iterable<com.vizcainoraw.hotelalura.model.Service> getAll(){
        return repository.findAll();
    }

    public com.vizcainoraw.hotelalura.model.Service create(com.vizcainoraw.hotelalura.model.Service service){
        return repository.save(service);
    }
    
}