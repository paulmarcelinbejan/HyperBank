package com.hyperbank.interests.interestratevariablehistory.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateSerializer;
import com.paulmarcelinbejan.toolbox.utils.time.DateUtils;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InterestRateVariableHistorySaveRequest {

	@JsonProperty
	@NotNull(message = "percentage must not be null")
	private BigDecimal percentage;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@NotNull(message = "startDate must not be null")
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate endDate = DateUtils.MAX_END_DATE;

}