package com.hotel.service.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class HotelDto implements Serializable{
	private String Id;
	private String name;
	private String location;
	private String about;
}
