package com.hyperbank.interests.interestrate.service;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface InterestRateService extends ReadService<Long, InterestRate>, DeleteService<Long> {

	InterestRate saveWithInterestRateFixedType() throws FunctionalException;
	
	InterestRate saveWithInterestRateVariableType() throws FunctionalException;
	
}
