package com.hyperbank.accounts.accountnotification.dto;

import java.time.Instant;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AccountNotificationResponse {

	@JsonProperty
	private Long id;

	@JsonProperty
	private Long accountId;

	@JsonProperty
	private String title;
	
	@JsonProperty
	private String message;
	
	@JsonProperty
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Instant dateTime;

}
