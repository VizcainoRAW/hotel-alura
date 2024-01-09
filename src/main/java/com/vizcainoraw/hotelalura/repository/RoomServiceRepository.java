package com.vizcainoraw.hotelalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vizcainoraw.hotelalura.model.RoomService;

@Repository
public interface RoomServiceRepository extends JpaRepository<RoomService, Integer>{
    
}