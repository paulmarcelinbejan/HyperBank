package com.hyperbank.interests.interestrate.service;

import com.hyperbank.interests.interestrate.entity.InterestRate;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

public interface InterestRateService extends ReadServiceHelper<Long, InterestRate>, DeleteServiceHelper<Long> {

	InterestRate saveWithInterestRateFixedType() throws FunctionalException;
	
	InterestRate saveWithInterestRateVariableType() throws FunctionalException;
	
}
