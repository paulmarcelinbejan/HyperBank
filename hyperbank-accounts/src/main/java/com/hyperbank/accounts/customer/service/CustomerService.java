package com.hyperbank.accounts.customer.service;

import com.hyperbank.accounts.customer.entity.Customer;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

public interface CustomerService extends ReadServiceHelper<Long, Customer>, DeleteServiceHelper<Long> {

	Customer saveWithCustomerIndividualType() throws FunctionalException;

	Customer saveWithCustomerLegalEntityType() throws FunctionalException;

}
