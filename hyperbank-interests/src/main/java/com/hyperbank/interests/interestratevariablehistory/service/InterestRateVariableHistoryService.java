package com.hyperbank.interests.interestratevariablehistory.service;

import org.springframework.stereotype.Service;

import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

@Service
public interface InterestRateVariableHistoryService extends CreateService<Long, InterestRateVariableHistory>, ReadService<Long, InterestRateVariableHistory> {

}
