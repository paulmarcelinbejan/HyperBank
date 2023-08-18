package com.hyperbank.accounts.customer.service;

import com.hyperbank.accounts.customer.entity.Customer;
import com.hyperbank.accounts.customerindividual.entity.CustomerIndividual;
import com.hyperbank.accounts.customerlegalentity.entity.CustomerLegalEntity;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;

public interface CustomerService extends ReadService<Long, Customer> {

	Long save(CustomerIndividual customerIndividual);

	Long save(CustomerLegalEntity customerLegalEntity);

}
