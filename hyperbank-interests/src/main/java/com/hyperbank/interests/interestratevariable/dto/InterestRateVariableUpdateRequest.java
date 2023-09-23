package com.hyperbank.interests.interestratevariable.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateSerializer;
import com.paulmarcelinbejan.toolbox.utils.time.DateUtils;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.FirstDayOfMonth;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.temporal.LastDayOfMonth;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InterestRateVariableUpdateRequest implements HistoricalLocalDateAware {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Long id;
	
	@JsonProperty
	@NotNull(message = "percentage must not be null")
	private BigDecimal percentage;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@NotNull(message = "startDate must not be null")
	@FirstDayOfMonth(message = "startDate must be the first day of the month")
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@LastDayOfMonth(message = "endDate must be the last day of the month")
	private LocalDate endDate = DateUtils.MAX_END_DATE;

	@Override
	public LocalDate startLocalDate() {
		return startDate;
	}

	@Override
	public LocalDate endLocalDate() {
		return endDate;
	}
	
}