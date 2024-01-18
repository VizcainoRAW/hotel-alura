package com.vizcainoraw.hotelalura.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.dto.Room.RoomMapper;
import com.vizcainoraw.hotelalura.dto.Room.RoomDto;
import com.vizcainoraw.hotelalura.model.Room;
import com.vizcainoraw.hotelalura.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository repository;
    private final RoomMapper mapper;

    public RoomService(RoomRepository repository, RoomMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<RoomDto> getAllRooms(){
        return repository.findAll().stream()
        .map(mapper)
        .collect(Collectors.toList());
    }

    public RoomDto getRoom(Integer id){
        return repository.findById(id)
            .map(mapper)
            .orElseThrow(()-> new ResourceNotFoundException(
                "dont found room id (%s)".formatted(id)
                ));
    }

    public RoomDto createRoom(Room room){
        return mapper.apply(
            repository.save(room)
            );
    }

}