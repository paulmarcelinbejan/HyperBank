package com.hyperbank.accounts.accountnotification.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paulmarcelinbejan.toolbox.jackson.deserializer.LocalDateTimeDeserializer;
import com.paulmarcelinbejan.toolbox.jackson.serializer.LocalDateTimeSerializer;

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
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@NotNull(message = "dateTime must not be null")
	private LocalDateTime dateTime;

}
