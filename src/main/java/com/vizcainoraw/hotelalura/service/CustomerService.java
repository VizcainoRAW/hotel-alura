package com.vizcainoraw.hotelalura.service;

import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.model.Customer;
import com.vizcainoraw.hotelalura.repository.CustomerRepository;

@Service
public class CustomerService{

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository){
        this.repository = repository;

    }

    public Iterable<Customer> getAll(){
        return repository.findAll();
    }

    public Customer create(Customer customer){
        return repository.save(customer);
    }

}