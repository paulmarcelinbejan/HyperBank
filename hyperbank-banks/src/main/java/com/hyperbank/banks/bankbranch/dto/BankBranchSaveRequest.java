package com.hyperbank.banks.bankbranch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BankBranchSaveRequest {
	
	@JsonProperty
	@NotNull(message = "bankId must not be null")
	private Integer bankId;

	@JsonProperty
	@NotNull( message = "locationId must not be null")
	private Long locationId;

}
