package com.hyperbank.accounts.accountnotification.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateTimeDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateTimeSerializer;

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
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime dateTime;

}
