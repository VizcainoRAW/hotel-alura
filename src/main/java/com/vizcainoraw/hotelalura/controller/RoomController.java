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


@RestController
@RequestMapping("/api")
public class RoomController {
    
    @Autowired
    private final RoomService service;

    public RoomController(RoomService service){
        this.service = service;
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<RoomDto>> getRooms(){
        return ResponseEntity.ok(
            service.getAllRooms()
            );

    }

    @GetMapping("/room/{id}")
    public ResponseEntity<RoomDto> getRoom(@PathVariable Integer id) {
        try {
            return ResponseEntity.ok(service.getRoom(id));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("/room")
    public ResponseEntity<?> addRoom(@RequestBody @Validated Room room){
        try {
            return ResponseEntity.ok(
                service.createRoom(room)
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
