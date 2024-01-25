package com.vizcainoraw.hotelalura.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vizcainoraw.hotelalura.dto.reservation.ReservationDto;
import com.vizcainoraw.hotelalura.service.ReservationService;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping("/reservations")
    public ResponseEntity<Iterable<ReservationDto>> getalllReservationDto() {
        return ResponseEntity.ok(service.findAllReservation());
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<ReservationDto> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(service.findReservationById(id));
    }
    
    @PostMapping("/reservation")
    public ResponseEntity<ReservationDto> createReservation(@RequestBody ReservationDto reservationDto) {
        ReservationDto cratedReservationDto = service.createReservation(reservationDto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(cratedReservationDto)
        .toUri();

        return ResponseEntity.created(uri).body(cratedReservationDto);
    }

    @PutMapping("/reservation/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable Long id, @RequestBody ReservationDto upReservationDto) {
       return ResponseEntity.ok(
        service.updateReservationById(id, upReservationDto)
       );
    }

    @DeleteMapping("/resevation/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id) {
        service.deleteReservation(id);
        return ResponseEntity.noContent().build();    
    }
}