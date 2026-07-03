package com.agp.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agp.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
