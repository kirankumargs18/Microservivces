package com.globallogic.dto;

import lombok.Data;

@Data
public class AddressDto {

	private Integer houseNo;
	private String streetName;
	private String city;
	private String state;
	private String country;
	private String zipcode;

}
