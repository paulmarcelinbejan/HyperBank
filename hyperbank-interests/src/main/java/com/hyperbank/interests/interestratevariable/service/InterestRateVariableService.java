package com.hyperbank.interests.interestratevariable.service;

import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface InterestRateVariableService extends CreateService<Long, InterestRateVariable>, ReadService<Long, InterestRateVariable> {

}
