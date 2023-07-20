package com.hyperbank.banks.bankbranch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class BankBranchDto {

	@JsonProperty
	@Null(groups = { CreateValidation.class }, message = "id must be null")
	@NotNull(groups = { UpdateValidation.class }, message = "id must not be null")
	private Integer id;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "bankId must not be null")
	private Integer bankId;

	@JsonProperty
	@NotNull(groups = { CreateValidation.class, UpdateValidation.class }, message = "locationId must not be null")
	private Long locationId;

	public interface CreateValidation {
		// validation group marker interface
	}

	public interface UpdateValidation {
		// validation group marker interface
	}

}
