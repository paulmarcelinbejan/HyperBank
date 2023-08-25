package com.hyperbank.accounts.accountinternal.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateTimeDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateTimeSerializer;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;

import lombok.Data;

@Data
public class AccountInternalResponse implements HistoricalLocalDateAware {

	@JsonProperty
	private Long id;

	@JsonProperty
	private Integer accountInternalTypeId;
	
	@JsonProperty
	private Long customerId;

	@JsonProperty
	private Integer currencyId;

	@JsonProperty
	private String iban;

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
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