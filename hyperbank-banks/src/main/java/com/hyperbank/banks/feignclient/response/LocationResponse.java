package com.hyperbank.banks.feignclient.response;

import lombok.Data;

@Data
public class LocationResponse {

	private Long id;

	private Integer cityId;

	private String streetName;

	private Integer streetNumber;

	private String postalCode;

}
