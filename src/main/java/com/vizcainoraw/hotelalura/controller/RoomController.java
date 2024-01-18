package com.vizcainoraw.hotelalura.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vizcainoraw.hotelalura.dto.Room.RoomDto;
import com.vizcainoraw.hotelalura.model.Room;
import com.vizcainoraw.hotelalura.service.RoomService;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api")
public class RoomController {
    
    @Autowired
    private final RoomService service;

    public RoomController(RoomService service){
        this.service = service;
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> getAllRooms(){
        return ResponseEntity.ok(
            service.findAllRooms()
            );

    }

    @GetMapping("/room/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.findRoomById(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    
    @PostMapping("/room")
    public ResponseEntity<?> createRoom(@RequestBody @Validated Room room){
        try {
            return ResponseEntity.ok(
                service.createRoom(room)
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    @PutMapping("/room/{id}")
    public ResponseEntity<?> updateRoom(@PathVariable Integer id, @RequestBody Room UpdatedRoom) {
        try {
            return ResponseEntity.ok(
                service.updateRoom(id, UpdatedRoom)
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
