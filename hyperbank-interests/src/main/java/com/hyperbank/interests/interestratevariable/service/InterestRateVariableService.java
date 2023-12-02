package com.hyperbank.interests.interestratevariable.service;

import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;

import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

public interface InterestRateVariableService extends CreateServiceHelper<Long, InterestRateVariable>, ReadServiceHelper<Long, InterestRateVariable> {

}
