package com.vizcainoraw.hotelalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vizcainoraw.hotelalura.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}