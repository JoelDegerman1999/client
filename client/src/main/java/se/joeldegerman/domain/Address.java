package se.joeldegerman.domain;

import lombok.Data;

@Data
public class Address {

	private String houseNumber;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	
}
