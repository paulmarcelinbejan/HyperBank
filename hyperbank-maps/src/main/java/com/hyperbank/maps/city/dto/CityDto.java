package com.hyperbank.maps.city.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class CityDto {

	@JsonProperty
	@Null(groups = { CreateValidation.class }, message = "id must be null")
	@NotNull(groups = { UpdateValidation.class }, message = "id must not be null")
	private Integer id;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "countryId must not be null")
	private Integer countryId;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "cityName must not be blank")
	private String cityName;

	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}

}
