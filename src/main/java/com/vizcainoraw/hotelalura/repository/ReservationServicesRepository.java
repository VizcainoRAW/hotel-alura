package com.vizcainoraw.hotelalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vizcainoraw.hotelalura.model.ReservationService;
import com.vizcainoraw.hotelalura.model.ReservationServiceId;

@Repository
public interface ReservationServicesRepository extends JpaRepository<ReservationService, ReservationServiceId>{
    
}