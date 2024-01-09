package com.vizcainoraw.hotelalura.service;

import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.model.Room;
import com.vizcainoraw.hotelalura.repository.RoomRepository;

@Service
public class RoomService {

    private final RoomRepository repository;

    public RoomService(RoomRepository repository){
        this.repository = repository;
    }

    public Iterable<Room> getAll(){
        return repository.findAll();
    }

    public Room create(Room room){
        return repository.save(room);
    }

}