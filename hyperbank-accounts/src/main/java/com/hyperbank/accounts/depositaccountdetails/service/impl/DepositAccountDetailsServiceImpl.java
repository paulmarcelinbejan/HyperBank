package com.hyperbank.accounts.depositaccountdetails.service.impl;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.depositaccountdetails.entity.DepositAccountDetails;
import com.hyperbank.accounts.depositaccountdetails.repository.DepositAccountDetailsRepository;
import com.hyperbank.accounts.depositaccountdetails.service.DepositAccountDetailsService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.DeleteServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class DepositAccountDetailsServiceImpl implements DepositAccountDetailsService {

	public DepositAccountDetailsServiceImpl(DepositAccountDetailsRepository depositAccountDetailsRepository) {
		createService = new CreateServiceImpl<>(depositAccountDetailsRepository, DepositAccountDetails::getId);
		readService = new ReadServiceImpl<>(depositAccountDetailsRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(DepositAccountDetails.class));
		deleteService = new DeleteServiceImpl<>(depositAccountDetailsRepository, readService);
	}

	private final CreateService<Long, DepositAccountDetails> createService;
	private final ReadService<Long, DepositAccountDetails> readService;
	private final DeleteService<Long> deleteService;

	@Value(value = "hyperbank.constants.deposit_account.interestrate")
	private BigDecimal interestRate;
	
	@Override
	@Transactional(readOnly = true)
	public DepositAccountDetails getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DepositAccountDetails findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<DepositAccountDetails> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<DepositAccountDetails> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<DepositAccountDetails> findAll() {
		return readService.findAll();
	}

	@Override
	public Long save(AccountInternal accountInternal) {
		return saveAndReturn(accountInternal).getId();
	}

	@Override
	public DepositAccountDetails saveAndReturn(AccountInternal accountInternal) {
		DepositAccountDetails depositAccountDetails = buildDepositAccountDetails(accountInternal);
		return createService.saveAndReturn(depositAccountDetails);
	}

	@Override
	public Collection<Long> save(Collection<AccountInternal> accountsInternal) {
		Collection<DepositAccountDetails> details = accountsInternal.stream().map(this::buildDepositAccountDetails).toList();
		return createService.save(details);
	}

	@Override
	public Collection<DepositAccountDetails> saveAndReturn(Collection<AccountInternal> accountsInternal) {
		Collection<DepositAccountDetails> details = accountsInternal.stream().map(this::buildDepositAccountDetails).toList();
		return createService.saveAndReturn(details);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteService.deleteManyIfPresent(ids);
	}
	
	private DepositAccountDetails buildDepositAccountDetails(AccountInternal accountInternal) {
		DepositAccountDetails depositAccountDetails = new DepositAccountDetails();
		depositAccountDetails.setInterestRateFixedId(null); //TODO
		depositAccountDetails.setAccountInternal(accountInternal);
		return depositAccountDetails;
	}
	
}
