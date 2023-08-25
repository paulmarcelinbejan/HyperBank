package com.hyperbank.banks.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class BankSaveRequest {

	@JsonProperty
	@NotBlank(message = "bankName must not be blank")
	private String bankName;

}
