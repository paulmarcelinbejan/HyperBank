package com.hyperbank.accounts.depositaccountdetails.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.utils.jackson.deserializer.LocalDateDeserializer;
import com.paulmarcelinbejan.toolbox.utils.jackson.serializer.LocalDateSerializer;

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
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate endDate;
	
}
