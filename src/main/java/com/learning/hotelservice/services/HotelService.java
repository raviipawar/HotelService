package com.learning.hotelservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Service;

import com.learning.hotelservice.entities.Hotel;
import com.learning.hotelservice.exceptions.ResourceNotFoundException;
import com.learning.hotelservice.repositories.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	public Hotel saveHotel(Hotel hotel) {
		String randomHotelId= UUID.randomUUID().toString();
		hotel.setHotelId(randomHotelId);
		return hotelRepository.save(hotel);
	}

	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}

	public Hotel getHotel(String hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow( () -> new ResourceNotFoundException("Hotel not found on server..!!" +hotelId));
	}
}
