package se.joeldegerman.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	
	
	private int id;
	private String firstName;
	private String lastName;
	
	private Address address;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	
	
	
}
