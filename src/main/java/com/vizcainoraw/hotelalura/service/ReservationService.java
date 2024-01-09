package com.vizcainoraw.hotelalura.service;

import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.model.Reservation;
import com.vizcainoraw.hotelalura.repository.ReservationRepository;

@Service
public class ReservationService {
    
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository){
        this.repository = repository;
    }

    public Iterable<Reservation> getAll(){
        return repository.findAll();
    }

    public Reservation createReservation(Reservation reservation){
        return repository.save(reservation);
    }

}