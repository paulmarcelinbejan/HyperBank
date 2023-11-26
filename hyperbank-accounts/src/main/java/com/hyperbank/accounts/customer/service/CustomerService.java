package com.hyperbank.accounts.customer.service;

import com.hyperbank.accounts.customer.entity.Customer;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;

public interface CustomerService extends ReadServiceHelper<Long, Customer>, DeleteServiceHelper<Long> {

	Customer saveWithCustomerIndividualType() throws FunctionalException;

	Customer saveWithCustomerLegalEntityType() throws FunctionalException;

}
