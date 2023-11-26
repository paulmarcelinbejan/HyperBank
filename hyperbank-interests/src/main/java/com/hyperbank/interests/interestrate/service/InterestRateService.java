package com.hyperbank.interests.interestrate.service;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

public interface InterestRateService extends ReadServiceHelper<Long, InterestRate>, DeleteServiceHelper<Long> {

	InterestRate saveWithInterestRateFixedType() throws FunctionalException;
	
	InterestRate saveWithInterestRateVariableType() throws FunctionalException;
	
}
