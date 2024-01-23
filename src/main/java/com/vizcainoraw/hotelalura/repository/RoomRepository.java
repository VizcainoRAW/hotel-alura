package com.vizcainoraw.hotelalura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vizcainoraw.hotelalura.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    
}