package com.hyperbank.banks.bank.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BankResponse {

	@JsonProperty
	private Integer id;

	@JsonProperty
	private String bankName;

}
