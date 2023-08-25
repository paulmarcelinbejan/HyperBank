package com.hyperbank.banks.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BankUpdateRequest {

	@JsonProperty
	@NotNull(message = "id must not be null")
	private Integer id;

	@JsonProperty
	@NotBlank(message = "bankName must not be blank")
	private String bankName;

}
