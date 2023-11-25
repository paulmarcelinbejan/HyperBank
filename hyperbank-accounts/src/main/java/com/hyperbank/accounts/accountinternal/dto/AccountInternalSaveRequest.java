package com.hyperbank.accounts.accountinternal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hyperbank.architecture.web.jackson.deserializer.LocalDateDeserializer;
import com.hyperbank.architecture.web.jackson.serializer.LocalDateSerializer;
import com.hyperbank.architecture.web.validation.temporal.annotation.NonOverlappingLocalDate;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;
import com.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NonOverlappingLocalDate(message = "startDate must be before endDate")
public class AccountInternalSaveRequest implements HistoricalLocalDateAware {

	@JsonProperty
	@NotNull(message = "accountInternalTypeId must not be null")
	private Integer accountInternalTypeId;
	
	@JsonProperty
	@NotNull(message = "customerId must not be null")
	private Long customerId;

	@JsonProperty
	@NotNull(message = "currencyId must not be null")
	private Integer currencyId;

	@JsonProperty
	@NotNull(message = "balance must not be null")
	private BigDecimal balance;
	
	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@NotNull(message = "startDate must not be null")
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
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