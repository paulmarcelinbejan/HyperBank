package com.hyperbank.accounts.accountinternal.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateTimeDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateTimeSerializer;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.NonOverlappingLocalDate;

import jakarta.validation.constraints.NotBlank;
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
	@NotBlank(message = "iban must not be blank")
	private String iban;

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@NotNull(message = "startDate must not be null")
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
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