package com.vizcainoraw.hotelalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vizcainoraw.hotelalura.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Customer getCustomerByEmail(String mail);
}