package com.vizcainoraw.hotelalura.service;

import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.model.Employee;
import com.vizcainoraw.hotelalura.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }
    
    public Iterable<Employee> getAll(){
        return repository.findAll();
    }

    public Employee create(Employee employee){
        return repository.save(employee);
    }
}