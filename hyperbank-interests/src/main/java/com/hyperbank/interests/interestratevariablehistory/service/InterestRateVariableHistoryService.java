package com.hyperbank.interests.interestratevariablehistory.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

@Service
public interface InterestRateVariableHistoryService extends CreateServiceHelper<Long, InterestRateVariableHistory>, ReadServiceHelper<Long, InterestRateVariableHistory> {

	Optional<InterestRateVariableHistory> findFirstByInterestRateVariableOrderByStartDateDesc(Long id) throws FunctionalException;
	
}
