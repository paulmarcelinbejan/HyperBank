package com.hyperbank.accounts.depositaccountdetails.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.accountinternal.entity.AccountInternal;
import com.hyperbank.accounts.depositaccountdetails.entity.DepositAccountDetails;
import com.hyperbank.accounts.depositaccountdetails.repository.DepositAccountDetailsRepository;
import com.hyperbank.accounts.depositaccountdetails.service.DepositAccountDetailsService;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class DepositAccountDetailsServiceImpl implements DepositAccountDetailsService {

	public DepositAccountDetailsServiceImpl(DepositAccountDetailsRepository depositAccountDetailsRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(depositAccountDetailsRepository, DepositAccountDetails::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(depositAccountDetailsRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(DepositAccountDetails.class));
		deleteServiceHelper = new DeleteServiceHelperImpl<>(depositAccountDetailsRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Long, DepositAccountDetails> createServiceHelper;
	private final ReadServiceHelper<Long, DepositAccountDetails> readServiceHelper;
	private final DeleteServiceHelper<Long> deleteServiceHelper;
	
	@Override
	@Transactional(readOnly = true)
	public DepositAccountDetails getReferenceById(Long id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public DepositAccountDetails findById(Long id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepositAccountDetails> findManyById(Collection<Long> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepositAccountDetails> findManyByIdIfPresent(Collection<Long> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DepositAccountDetails> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Long save(AccountInternal accountInternal) throws FunctionalException {
		return saveAndReturn(accountInternal).getId();
	}

	@Override
	public DepositAccountDetails saveAndReturn(AccountInternal accountInternal) throws FunctionalException {
		DepositAccountDetails depositAccountDetails = buildDepositAccountDetails(accountInternal);
		return createServiceHelper.saveAndReturn(depositAccountDetails);
	}

	@Override
	public Collection<Long> save(Collection<AccountInternal> accountsInternal) throws FunctionalException {
		Collection<DepositAccountDetails> details = accountsInternal.stream().map(this::buildDepositAccountDetails).toList();
		return createServiceHelper.save(details);
	}

	@Override
	public Collection<DepositAccountDetails> saveAndReturn(Collection<AccountInternal> accountsInternal) throws FunctionalException {
		Collection<DepositAccountDetails> details = accountsInternal.stream().map(this::buildDepositAccountDetails).toList();
		return createServiceHelper.saveAndReturn(details);
	}

	@Override
	public void delete(Long id) throws FunctionalException {
		deleteServiceHelper.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Long id) {
		deleteServiceHelper.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Long> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Long> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
	private DepositAccountDetails buildDepositAccountDetails(AccountInternal accountInternal) {
		DepositAccountDetails depositAccountDetails = new DepositAccountDetails();
		depositAccountDetails.setInterestRateFixedId(null); //TODO
		depositAccountDetails.setAccountInternal(accountInternal);
		return depositAccountDetails;
	}
	
}
