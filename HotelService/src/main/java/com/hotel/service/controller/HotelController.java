package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.dto.HotelDto;
import com.hotel.service.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;

	@PostMapping("/add-hotel")
	public ResponseEntity<HotelDto> addHotelData(@RequestBody HotelDto hotelDto){
		return new ResponseEntity<>(this.hotelService.addHotel(hotelDto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{hotelId}/update")
	public ResponseEntity<HotelDto> updateHotelData(@PathVariable String hotelId, @RequestBody HotelDto hotelDto){
		return new ResponseEntity<>(this.hotelService.updateHotelDetails(hotelId, hotelDto), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/hotellist")
	public ResponseEntity<List<HotelDto>> getAllHotelData(){
		return ResponseEntity.ok(this.hotelService.getAllHotelList());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<HotelDto> getHotelDataById(@PathVariable String hotelId){
		return ResponseEntity.ok(this.hotelService.getAllHotelById(hotelId));
	}
	
	@PatchMapping("/{hotelId}/update")
	public ResponseEntity<HotelDto> updateHotelDataPartially(@PathVariable String hotelId, @RequestBody HotelDto hotelDto){
		return new ResponseEntity<>(this.hotelService.updateHotelDetailsPartially(hotelId, hotelDto), HttpStatus.ACCEPTED);
	}

}
