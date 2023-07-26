package com.learning.hotelservice.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.hotelservice.entities.Hotel;
import com.learning.hotelservice.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@PostMapping("/add")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
		Hotel hotel1 = hotelService.saveHotel(hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel1);
	}

	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable String hotelId) {
		Hotel hotel = hotelService.getHotel(hotelId);
		return ResponseEntity.ok(hotel);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> getAllHotel() {
		List<Hotel> allhotel = hotelService.getAllHotel();
		return ResponseEntity.ok(allhotel);
	}

	@GetMapping("/unique/{hotelId}")
	public ResponseEntity<Hotel> getAllHotelandFindOne(@PathVariable String hotelId) {
		List<Hotel> allhotel = hotelService.getAllHotel();
		Predicate<Hotel> predicate = hotel1 -> hotel1.getHotelId().equals(hotelId);
		return ResponseEntity.ok(allhotel.stream().filter(predicate).findFirst().get());
	}

	@GetMapping("/hateoas/{hotelIdLink}")
	public EntityModel<Hotel> getSingleHotelWithLink(@PathVariable String hotelIdLink) {
		Hotel hotel = hotelService.getHotel(hotelIdLink);
		EntityModel<Hotel> entityModel = EntityModel.of(hotel);
		// to add link to controller specific method
		WebMvcLinkBuilder webMvcLinkBuilder = linkTo(methodOn(this.getClass()).getAllHotel());
		entityModel.add(webMvcLinkBuilder.withRel("all"));
		return entityModel;
	}
}
