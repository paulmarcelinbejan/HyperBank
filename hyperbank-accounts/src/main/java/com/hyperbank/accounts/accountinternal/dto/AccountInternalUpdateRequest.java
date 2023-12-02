package com.hyperbank.accounts.accountinternal.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hyperbank.architecture.web.jackson.deserializer.LocalDateDeserializer;
import com.hyperbank.architecture.web.jackson.serializer.LocalDateSerializer;
import com.hyperbank.architecture.web.validation.temporal.annotation.NonOverlappingLocalDate;

import io.github.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NonOverlappingLocalDate(message = "startDate must be before endDate")
public class AccountInternalUpdateRequest implements HistoricalLocalDateAware {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Long id;

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
	@NotNull(message = "endDate must not be null")
	private LocalDate endDate;

	@Override
	public LocalDate startLocalDate() {
		return startDate;
	}

	@Override
	public LocalDate endLocalDate() {
		return endDate;
	}
	
}