package com.vizcainoraw.hotelalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vizcainoraw.hotelalura.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    
}