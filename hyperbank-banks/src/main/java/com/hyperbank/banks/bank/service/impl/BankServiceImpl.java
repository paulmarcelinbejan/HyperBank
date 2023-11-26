package com.hyperbank.banks.bank.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.banks.bank.entity.Bank;
import com.hyperbank.banks.bank.mapper.BankMapper;
import com.hyperbank.banks.bank.repository.BankRepository;
import com.hyperbank.banks.bank.service.BankService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.service.helper.CreateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.DeleteServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.ReadServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.UpdateServiceHelper;
import com.paulmarcelinbejan.toolbox.service.helper.impl.CreateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.DeleteServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.ReadServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.impl.UpdateServiceHelperImpl;
import com.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class BankServiceImpl implements BankService {

	public BankServiceImpl(BankMapper bankMapper, BankRepository bankRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(bankRepository, Bank::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(bankRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Bank.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				bankRepository,
				bankMapper,
				readServiceHelper,
				Bank::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(bankRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, Bank> createServiceHelper;
	private final ReadServiceHelper<Integer, Bank> readServiceHelper;
	private final UpdateServiceHelper<Integer, Bank> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public Bank getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Bank findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bank> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bank> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Bank> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(Bank entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}
	
	@Override
	public Bank saveAndReturn(Bank entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(Collection<Bank> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}
	
	@Override
	public List<Bank> saveAndReturn(Collection<Bank> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Integer update(Bank entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public Bank updateAndReturn(Bank entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(Collection<Bank> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<Bank> updateAndReturn(Collection<Bank> entities) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entities);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteServiceHelper.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Integer id) {
		deleteServiceHelper.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Integer> ids) throws FunctionalException {
		deleteServiceHelper.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Integer> ids) {
		deleteServiceHelper.deleteManyIfPresent(ids);
	}
	
}
