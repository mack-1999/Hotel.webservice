package com.hotel.service.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.hotel.service.dto.HotelDto;
import com.hotel.service.repository.HotelRepo;
import com.hotel.service.service.HotelService;

public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public HotelDto addHotel(HotelDto hotelDto) {
		return null;
	}

	@Override
	public HotelDto updateHotelDetails(String hotelId, HotelDto hotelDto) {
		return null;
	}

	@Override
	public List<HotelDto> getAllHotelList() {
		return null;
	}

	@Override
	public HotelDto getAllHotelById(String hotelId) {
		return null;
	}

}
