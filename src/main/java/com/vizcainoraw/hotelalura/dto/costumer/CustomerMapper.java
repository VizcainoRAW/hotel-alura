package com.vizcainoraw.hotelalura.dto.costumer;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.model.Customer;

@Service
public class CustomerMapper implements Function<Customer, CustomerDto>{
    
    @Override
    public CustomerDto apply(Customer customer){
        return new CustomerDto(
            customer.getCustomerId(),
            customer.getEmail(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getPhoneNumber()
        );
    }
}