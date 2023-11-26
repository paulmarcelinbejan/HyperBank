package com.hyperbank.interests.interestratevariablehistory.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

@Service
public interface InterestRateVariableHistoryService extends CreateServiceHelper<Long, InterestRateVariableHistory>, ReadServiceHelper<Long, InterestRateVariableHistory> {

	Optional<InterestRateVariableHistory> findFirstByInterestRateVariableOrderByStartDateDesc(Long id) throws FunctionalException;
	
}
