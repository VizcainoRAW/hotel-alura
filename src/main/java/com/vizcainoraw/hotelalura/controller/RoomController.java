package com.vizcainoraw.hotelalura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vizcainoraw.hotelalura.model.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {
    
    @Autowired
    private final RoomService service;

    public RoomController(RoomService service){
        this.service = service;
    }

}
