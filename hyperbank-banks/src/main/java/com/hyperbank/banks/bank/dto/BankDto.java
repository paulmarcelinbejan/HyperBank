package com.hyperbank.banks.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class BankDto {

	@JsonProperty
	@Null(groups = { CreateValidation.class }, message = "id must be null")
	@NotNull(groups = { UpdateValidation.class }, message = "id must not be null")
	private Integer id;

	@JsonProperty
	@NotBlank(groups = { CreateValidation.class, UpdateValidation.class }, message = "bankName must not be blank")
	private String bankName;

	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}

}
