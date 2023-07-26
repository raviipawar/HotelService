package com.learning.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.hotelservice.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
