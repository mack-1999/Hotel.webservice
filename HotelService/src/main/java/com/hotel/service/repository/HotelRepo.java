package com.hotel.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.service.entities.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String>{

}
