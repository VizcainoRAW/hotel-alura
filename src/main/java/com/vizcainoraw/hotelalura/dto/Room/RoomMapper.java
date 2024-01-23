package com.vizcainoraw.hotelalura.dto.Room;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import com.vizcainoraw.hotelalura.model.Room;

@Service
public class RoomMapper implements Function<Room, RoomDto>{

    @Override
    public RoomDto apply(Room room) {
        return new RoomDto(
            room.getRoomId(),
            room.getRoomNumber(),
            room.getType(),
            room.getPrice(),
            room.getOccupied()
        );
    }
    
}