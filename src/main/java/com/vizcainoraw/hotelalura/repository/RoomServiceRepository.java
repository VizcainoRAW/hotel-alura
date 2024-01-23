package com.vizcainoraw.hotelalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vizcainoraw.hotelalura.model.RoomService;
import com.vizcainoraw.hotelalura.model.RoomServiceId;

@Repository
public interface RoomServiceRepository extends JpaRepository<RoomService, RoomServiceId>{
    
}