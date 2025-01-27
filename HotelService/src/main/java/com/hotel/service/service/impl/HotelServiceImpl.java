package com.hotel.service.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.dto.HotelDto;
import com.hotel.service.entities.Hotel;
import com.hotel.service.exception.ResourceNotFoundException;
import com.hotel.service.repository.HotelRepo;
import com.hotel.service.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepo hotelRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public HotelDto addHotel(HotelDto hotelDto) {
		
		// Generate & Set random hotel id
		String randomHotelId = UUID.randomUUID().toString();
		hotelDto.setId(randomHotelId);
		
		// Converting DTO to entity class
		Hotel hotelData = modelMapper.map(hotelDto, Hotel.class);
		
		// Save data into DB
		Hotel savedHotelData = this.hotelRepo.save(hotelData);
		
		// Return DTO
		return modelMapper.map(savedHotelData, HotelDto.class);
	}

	@Override
	public HotelDto updateHotelDetails(String hotelId, HotelDto hotelDto) {
		// Find hotel id in DB or else throw an user defined exception
		Hotel hotel = this.hotelRepo.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with id" + hotelId + "not found"));
		
		hotelDto.setId(hotel.getId());
			
		// Converting DTO to entity class
		Hotel hotelData = modelMapper.map(hotelDto, Hotel.class);
			
		// Save data into DB
		Hotel savedHotelData = this.hotelRepo.save(hotelData);
			
		// Return DTO
		return modelMapper.map(savedHotelData, HotelDto.class);
	}

	@Override
	public List<HotelDto> getAllHotelList() {
		List<Hotel> hotels = this.hotelRepo.findAll();
		
		List<HotelDto> hotelDtos = hotels.stream()
				.map((hotel) -> this.modelMapper.map(hotel, HotelDto.class)).collect(Collectors.toList());
		
		return hotelDtos;
	}

	@Override
	public HotelDto getAllHotelById(String hotelId) {
		// Find hotel id in DB or else throw an user defined exception
		Hotel hotel = this.hotelRepo.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel with id" + hotelId + "not found"));

		return modelMapper.map(hotel, HotelDto.class);
	}
	
	@Override
	public HotelDto updateHotelDetailsPartially(String hotelId, HotelDto hotelDto) {
	    // Find the hotel by ID or throw an exception
	    Hotel hotel = this.hotelRepo.findById(hotelId)
	            .orElseThrow(() -> new ResourceNotFoundException("Hotel with id " + hotelId + " not found"));

	    // Update only the fields provided in the DTO
	    if (hotelDto.getName() != null) {
	        hotel.setName(hotelDto.getName());
	    }
	    if (hotelDto.getAbout() != null) {
	        hotel.setAbout(hotelDto.getAbout());
	    }
	    if (hotelDto.getLocation() != null) {
	        hotel.setLocation(hotelDto.getLocation());
	    }
	    // Repeat for other fields as needed

	    // Save the partially updated entity to the database
	    Hotel updatedHotel = this.hotelRepo.save(hotel);

	    // Convert the updated entity back to DTO and return it
	    return modelMapper.map(updatedHotel, HotelDto.class);
	}

}
