package com.hyperbank.banks.bankbranch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BankBranchResponse {

	@JsonProperty
	private Integer id;

	@JsonProperty
	private Integer bankId;

	@JsonProperty
	private Long locationId;

}
