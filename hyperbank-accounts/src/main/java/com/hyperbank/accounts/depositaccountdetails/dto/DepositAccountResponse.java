package com.hyperbank.accounts.depositaccountdetails.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateTimeDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateTimeSerializer;

import lombok.Data;

@Data
public class DepositAccountResponse {

	@JsonProperty
	private Long id;
	
	@JsonProperty
	private Integer accountInternalTypeId;
	
	@JsonProperty
	private Long customerId;

	@JsonProperty
	private Integer currencyId;
	
	@JsonProperty
	private BigDecimal balance;
	
	@JsonProperty
	private Long interestRateFixedId;

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDate endDate;
	
}
