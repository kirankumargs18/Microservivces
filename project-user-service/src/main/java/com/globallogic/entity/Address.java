package com.globallogic.entity;

import lombok.Data;

@Data
public class Address {
	
	private Integer houseNo;
	private String streetName;
	private String city;
	private String state;
	private String country;
	private String zipcode;

}
