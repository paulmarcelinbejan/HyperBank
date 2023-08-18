package com.hyperbank.banks.bank.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.banks.bank.entity.Bank;
import com.hyperbank.banks.bank.mapper.BankMapper;
import com.hyperbank.banks.bank.repository.BankRepository;
import com.hyperbank.banks.bank.service.BankService;
import com.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import com.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import com.paulmarcelinbejan.toolbox.web.service.CreateService;
import com.paulmarcelinbejan.toolbox.web.service.DeleteService;
import com.paulmarcelinbejan.toolbox.web.service.ReadService;
import com.paulmarcelinbejan.toolbox.web.service.UpdateService;
import com.paulmarcelinbejan.toolbox.web.service.impl.CreateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.DeleteServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.ReadServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.impl.UpdateServiceImpl;
import com.paulmarcelinbejan.toolbox.web.service.utils.ServiceUtils;

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class BankServiceImpl implements BankService {

	public BankServiceImpl(BankMapper bankMapper, BankRepository bankRepository) {
		createService = new CreateServiceImpl<>(bankRepository, Bank::getId);
		readService = new ReadServiceImpl<>(bankRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(Bank.class));
		updateService = new UpdateServiceImpl<>(
				bankRepository,
				bankMapper,
				readService,
				Bank::getId);
		deleteService = new DeleteServiceImpl<>(bankRepository, readService);
	}

	private final CreateService<Integer, Bank> createService;
	private final ReadService<Integer, Bank> readService;
	private final UpdateService<Integer, Bank> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Bank getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Bank findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Bank> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Bank> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Bank> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(Bank entity) {
		return createService.save(entity);
	}
	
	@Override
	public Bank saveAndReturn(Bank entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<Bank> entities) {
		return createService.save(entities);
	}
	
	@Override
	public Collection<Bank> saveAndReturn(Collection<Bank> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Integer update(Bank entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public Bank updateAndReturn(Bank entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<Bank> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<Bank> updateAndReturn(Collection<Bank> entities) throws FunctionalException {
		return updateService.updateAndReturn(entities);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Integer id) {
		deleteService.deleteIfPresent(id);
	}

	@Override
	public void deleteMany(Collection<Integer> ids) throws FunctionalException {
		deleteService.deleteMany(ids);
	}

	@Override
	public void deleteManyIfPresent(Collection<Integer> ids) {
		deleteService.deleteManyIfPresent(ids);
	}
	
}
