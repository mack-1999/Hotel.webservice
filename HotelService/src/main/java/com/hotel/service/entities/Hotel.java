package com.hotel.service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Hotel {
	@Id
	private String Id;
	private String name;
	private String location;
	private String about;
}
