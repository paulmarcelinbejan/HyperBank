package com.hyperbank.maps.location.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LocationDto {

	@JsonProperty
	@Null(groups = { CreateValidation.class }, message = "id must be null")
	@NotNull(groups = { UpdateValidation.class }, message = "id must not be null")
	private Long id;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "cityId must not be null")
	private Integer cityId;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "streetName must not be blank")
	private String streetName;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "streetNumber must not be null")
	@Positive(groups = { CreateValidation.class, UpdateValidation.class }, message = "streetNumber must be positive")
	private Integer streetNumber;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "postalCode must not be blank")
	private String postalCode;

	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}

}
