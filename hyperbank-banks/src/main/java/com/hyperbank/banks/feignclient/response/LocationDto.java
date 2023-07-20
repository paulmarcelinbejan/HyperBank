package com.hyperbank.banks.feignclient.response;

import lombok.Data;

@Data
public class LocationDto {

	private Long id;

	private Integer cityId;

	private String streetName;

	private Integer streetNumber;

	private String postalCode;

}
