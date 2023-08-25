package com.hyperbank.accounts.customer.service;

import com.hyperbank.accounts.customer.entity.Customer;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface CustomerService extends ReadService<Long, Customer>, DeleteService<Long> {

	Customer saveWithCustomerIndividualType();

	Customer saveWithCustomerLegalEntityType();

}
