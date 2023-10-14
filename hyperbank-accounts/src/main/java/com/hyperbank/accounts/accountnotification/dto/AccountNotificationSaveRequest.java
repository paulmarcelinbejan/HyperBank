package com.hyperbank.accounts.accountnotification.dto;

import java.time.Instant;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountNotificationSaveRequest {
	
	@JsonProperty
	@NotNull(message = "accountId must not be null")
	private Long accountId;

	@JsonProperty
	@NotBlank(message = "accountId must not be blank")
	private String title;
	
	@JsonProperty
	@NotBlank(message = "accountId must not be blank")
	private String message;
	
	@JsonProperty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@NotNull(message = "dateTime must not be null")
	private Instant dateTime;

}
