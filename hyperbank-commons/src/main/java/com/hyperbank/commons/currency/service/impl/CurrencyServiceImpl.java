package com.hyperbank.commons.currency.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.commons.currency.entity.Currency;
import com.hyperbank.commons.currency.mapper.CurrencyMapper;
import com.hyperbank.commons.currency.repository.CurrencyRepository;
import com.hyperbank.commons.currency.service.CurrencyService;
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
public class CurrencyServiceImpl implements CurrencyService {

	public CurrencyServiceImpl(CurrencyMapper currencyMapper, CurrencyRepository currencyRepository) {
		createService = new CreateServiceImpl<>(currencyRepository, Currency::getId);
		readService = new ReadServiceImpl<>(currencyRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(Currency.class));
		updateService = new UpdateServiceImpl<>(
				currencyRepository,
				currencyMapper,
				readService,
				Currency::getId);
		deleteService = new DeleteServiceImpl<>(currencyRepository, readService);
	}

	private final CreateService<Integer, Currency> createService;
	private final ReadService<Integer, Currency> readService;
	private final UpdateService<Integer, Currency> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Currency getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Currency findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Currency> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Currency> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Currency> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(Currency entity) {
		return createService.save(entity);
	}

	@Override
	public Currency saveAndReturn(Currency entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<Currency> entities) {
		return createService.save(entities);
	}

	@Override
	public Collection<Currency> saveAndReturn(Collection<Currency> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Integer update(Currency entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public Currency updateAndReturn(Currency entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<Currency> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<Currency> updateAndReturn(Collection<Currency> entities) throws FunctionalException {
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
