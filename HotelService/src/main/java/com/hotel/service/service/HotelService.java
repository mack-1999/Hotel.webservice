package com.hotel.service.service;

import java.util.List;

import com.hotel.service.dto.HotelDto;

public interface HotelService {

	//! Create a new Hotel
	HotelDto addHotel(HotelDto hotelDto);
	
	//! Update a hotel details
	HotelDto updateHotelDetails(String hotelId, HotelDto hotelDto);
	
	//! Get all hotels
	List<HotelDto> getAllHotelList();
	
	//! Get a hotel by hotelId
	HotelDto getAllHotelById(String hotelId);
	
	HotelDto updateHotelDetailsPartially(String hotelId, HotelDto hotelDto);
}
