package com.hyperbank.interests.interestratevariable.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hyperbank.architecture.web.jackson.deserializer.LocalDateDeserializer;
import com.hyperbank.architecture.web.jackson.serializer.LocalDateSerializer;
import com.hyperbank.architecture.web.validation.temporal.annotation.FirstDayOfMonth;
import com.hyperbank.architecture.web.validation.temporal.annotation.LastDayOfMonth;
import com.hyperbank.architecture.web.validation.temporal.annotation.NonOverlappingLocalDate;
import com.hyperbank.interests.interestratevariablehistory.validator.NonOverlappingHistory;

import io.github.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;
import io.github.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NonOverlappingLocalDate
@NonOverlappingHistory
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
	private LocalDate endDate = LocalDateUtils.MAX_END_DATE;

	@Override
	public LocalDate startLocalDate() {
		return startDate;
	}

	@Override
	public LocalDate endLocalDate() {
		return endDate;
	}
	
}