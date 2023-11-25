package com.hyperbank.interests.interestratevariablehistory.validator;

import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.interests.interestratevariable.dto.InterestRateVariableUpdateRequest;
import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.hyperbank.interests.interestratevariablehistory.service.InterestRateVariableHistoryService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.utils.time.localdate.LocalDateUtils;
import com.paulmarcelinbejan.toolbox.utils.validation.stereotype.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@Validator
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NonOverlappingHistoryValidator implements ConstraintValidator<NonOverlappingHistory, InterestRateVariableUpdateRequest> {

	private final InterestRateVariableHistoryService interestRateVariableHistoryService;
	
	@Override
	public boolean isValid(InterestRateVariableUpdateRequest value, ConstraintValidatorContext context) {
		
		if(value.getId() == null) {
			return false;
		}
		
		Optional<InterestRateVariableHistory> lastHistory;
		try {
			lastHistory = interestRateVariableHistoryService.findFirstByInterestRateVariableOrderByStartDateDesc(value.getId());
		} catch (FunctionalException e) {
			return false;
		}
		
		if(lastHistory.isEmpty()) {
			return true;
		}
		
		if(LocalDateUtils.isAfterOrEquals(lastHistory.get().getStartDate(), value.getStartDate())) {
			return false;
		}
		
		return true;
		
	}
	
}
