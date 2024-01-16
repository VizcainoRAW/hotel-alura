package com.vizcainoraw.hotelalura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vizcainoraw.hotelalura.service.CustomerService;
import com.vizcainoraw.hotelalura.dto.costumer.CustomerDto;
import com.vizcainoraw.hotelalura.model.Customer;

@RestController
@RequestMapping("/api")
public class CustomerController {
    
    @Autowired
    private final CustomerService service;

    public CustomerController(CustomerService service){
        this.service = service;
    }

    @GetMapping("customers")
    public Iterable<CustomerDto> getCustmers() { return service.getAllCustomers(); } 

    @GetMapping("customer/{id}")
    public ResponseEntity<CustomerDto> getCustmer(@PathVariable Integer id){
        try {
            return new ResponseEntity<>(service.getCustomer(id), HttpStatus.OK);
        } catch (Exception e) {
           return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody @Validated Customer customer) {
        return ResponseEntity.ok(
            service.create(customer)
        );
    }

    @PutMapping("customer/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody Customer updatedCustomer){
        return service.updateCustomer(id, updatedCustomer)
        .map(updateCustomer -> new ResponseEntity<>(updatedCustomer, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("customer/{id}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Integer id){
        if(!service.deleteCustomer(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }  
}