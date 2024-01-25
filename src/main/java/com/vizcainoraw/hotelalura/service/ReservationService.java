package com.vizcainoraw.hotelalura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.dto.reservation.ReservationDto;
import com.vizcainoraw.hotelalura.dto.reservation.ReservationMapper;
import com.vizcainoraw.hotelalura.model.Customer;
import com.vizcainoraw.hotelalura.model.Reservation;
import com.vizcainoraw.hotelalura.model.Room;
import com.vizcainoraw.hotelalura.repository.CustomerRepository;
import com.vizcainoraw.hotelalura.repository.ReservationRepository;
import com.vizcainoraw.hotelalura.repository.ReservationServicesRepository;
import com.vizcainoraw.hotelalura.repository.RoomRepository;

import lombok.NonNull;

@Service
public class ReservationService {
    
    private final ReservationRepository repository;
    private final CustomerRepository customerRepository;
    private final RoomRepository roomRepository;
    private final ReservationServicesRepository reservationServicesRepository;
    private final ReservationMapper mapper;

    public ReservationService(ReservationRepository repository, CustomerRepository customerRepository,
            RoomRepository roomRepository, ReservationMapper mapper, ReservationServicesRepository reservationServicesRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
        this.roomRepository = roomRepository;
        this.mapper = mapper;
        this.reservationServicesRepository = reservationServicesRepository;
    }

    public List<ReservationDto> findAllReservation(){
        return repository.findAll().stream()
        .map(reservation -> mapper.reservationToDto(reservation))
        .collect(Collectors.toList());
    }

    public ReservationDto findReservationById(@NonNull Long id){
        return repository.findById(id)
        .map(reservation -> mapper.reservationToDto(reservation))
        .orElseThrow(()-> new ResourceNotFoundException(
            "no found reservation with id (%s)".formatted(id)));
    }

    public ReservationDto createReservation(@NonNull ReservationDto reservationRequest){
        Reservation reservation = mapper.DtoToReservation(reservationRequest);

        Long roomId = reservationRequest.roomId();
        Long customerId = reservationRequest.customerId();
        if (customerId == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        if (roomId == null) {
            throw new IllegalArgumentException("Room ID cannot be null");
        }

        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        
        Room room = roomRepository.findById(roomId)
            .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
        
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        
        return mapper.reservationToDto(
            repository.save(reservation)
            );
    }

    public ReservationDto updateReservationById(@NonNull Long id, ReservationDto updateReservationDto) {
        Reservation reservation = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "No found reservation with id (%s) to update".formatted(id)
            ));
        Long roomId = updateReservationDto.id();
        if (roomId == null) {
            throw new IllegalArgumentException("room id can't be null");
        }

        Room room = roomRepository.findById(roomId)
        .orElseThrow(() -> new ResourceNotFoundException("Room not found"));
    
        reservation.setRoom(room);
        reservation.setStartDate(updateReservationDto.startDate());
        reservation.setEndDate(updateReservationDto.endDate());
        
        return mapper.reservationToDto(
            repository.save(reservation)
        );
    }

    public void deleteReservation(@NonNull Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("no foun Reservation with id (%s) to delete");
        }
        repository.deleteById(id);
    }
}