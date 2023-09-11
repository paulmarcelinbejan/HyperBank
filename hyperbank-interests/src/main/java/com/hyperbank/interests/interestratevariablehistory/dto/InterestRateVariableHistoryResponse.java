package com.hyperbank.interests.interestratevariablehistory.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateSerializer;

import lombok.Data;

@Data
public class InterestRateVariableHistoryResponse {

	@JsonProperty
	private Long id;

	@JsonProperty
	private BigDecimal percentage;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate endDate;

}