package com.vizcainoraw.hotelalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vizcainoraw.hotelalura.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{
    
}