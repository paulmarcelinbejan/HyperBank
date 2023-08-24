package com.hyperbank.accounts.accountinternal.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hyperbank.accounts.accountinternal.dto.AccountInternalDto.CreateValidation;
import com.hyperbank.accounts.accountinternal.dto.AccountInternalDto.UpdateValidation;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateTimeDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateTimeSerializer;
import com.paulmarcelinbejan.toolbox.utils.time.aware.HistoricalLocalDateAware;
import com.paulmarcelinbejan.toolbox.utils.validation.annotation.NonOverlappingLocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@NonOverlappingLocalDate(groups = { CreateValidation.class, UpdateValidation.class }, message = "startDate must be before endDate")
public class AccountInternalDto implements HistoricalLocalDateAware {

	@JsonProperty
	@Null(groups = { CreateValidation.class }, message = "id must be null")
	@NotNull(groups = { UpdateValidation.class }, message = "id must not be null")
	private Long id;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "accountInternalTypeId must not be null")
	private Integer accountInternalTypeId;
	
	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "customerId must not be null")
	private Long customerId;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "currencyId must not be null")
	private Integer currencyId;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "iban must not be blank")
	private String iban;

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@NotNull(groups = { CreateValidation.class }, message = "startDate must not be null")
	private LocalDate startDate;

	@JsonProperty
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@NotNull(groups = { CreateValidation.class }, message = "endDate must not be null")
	private LocalDate endDate;

	@Override
	public LocalDate startLocalDate() {
		return startDate;
	}

	@Override
	public LocalDate endLocalDate() {
		return endDate;
	}
	
	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}
	
}