package com.hyperbank.types.currency.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.types.currency.entity.Currency;
import com.hyperbank.types.currency.mapper.CurrencyMapper;
import com.hyperbank.types.currency.repository.CurrencyRepository;
import com.hyperbank.types.currency.service.CurrencyService;
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
public class CurrencyServiceImpl implements CurrencyService {

	public CurrencyServiceImpl(CurrencyMapper currencyMapper, CurrencyRepository currencyRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(currencyRepository, Currency::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(currencyRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Currency.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				currencyRepository,
				currencyMapper,
				readServiceHelper,
				Currency::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(currencyRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, Currency> createServiceHelper;
	private final ReadServiceHelper<Integer, Currency> readServiceHelper;
	private final UpdateServiceHelper<Integer, Currency> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public Currency getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Currency findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Currency> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Currency> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Currency> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(Currency entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}

	@Override
	public Currency saveAndReturn(Currency entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(Collection<Currency> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}

	@Override
	public List<Currency> saveAndReturn(Collection<Currency> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}

	@Override
	public Integer update(Currency entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public Currency updateAndReturn(Currency entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(Collection<Currency> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<Currency> updateAndReturn(Collection<Currency> entities) throws FunctionalException {
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
