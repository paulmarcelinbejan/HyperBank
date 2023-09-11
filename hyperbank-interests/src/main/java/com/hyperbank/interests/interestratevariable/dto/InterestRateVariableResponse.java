package com.hyperbank.interests.interestratevariable.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hyperbank.interests.interestratevariablehistory.dto.InterestRateVariableHistoryResponse;

import lombok.Data;

@Data
public class InterestRateVariableResponse {

	@JsonProperty
	private Long id;

	@JsonProperty
	private String name;
	
	@JsonProperty
	private List<InterestRateVariableHistoryResponse> interestRateVariableHistoryList;
    
}