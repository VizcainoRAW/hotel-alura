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

    public List<RoomDto> findAllRooms(){
        return repository.findAll().stream()
        .map(mapper)
        .collect(Collectors.toList());
    }

    public RoomDto findRoomById(Integer id){
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

    public RoomDto updateRoom(Integer id, Room updateRoom){
        // check if room exits
        Room room = repository.findById(id).get();
        if(room == null){
            throw new ResourceNotFoundException(
                "not found room with the id (%s)".formatted(id)
            );
        }

        // update room
        room.setRoomNumber(updateRoom.getRoomNumber());
        room.setType(updateRoom.getType());
        room.setPrice(updateRoom.getPrice());
        room.setOccupied(updateRoom.getOccupied());
        return mapper.apply(repository.save(room));
    }


    public void deleteRoom(Integer id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }else{
            throw new ResourceNotFoundException(
                "not found room with the id (%s) to delete".formatted(id)
            );
        }

    } 

}