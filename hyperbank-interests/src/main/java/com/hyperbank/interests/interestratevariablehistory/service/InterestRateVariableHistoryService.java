package com.hyperbank.interests.interestratevariablehistory.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

@Service
public interface InterestRateVariableHistoryService extends CreateService<Long, InterestRateVariableHistory>, ReadService<Long, InterestRateVariableHistory> {

	Optional<InterestRateVariableHistory> findFirstByInterestRateVariableOrderByStartDateDesc(Long id) throws FunctionalException;
	
}
