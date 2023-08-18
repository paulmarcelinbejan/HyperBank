package com.hyperbank.accounts.customerlegalentity.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.customerlegalentity.entity.CustomerLegalEntity;
import com.hyperbank.accounts.customerlegalentity.mapper.CustomerLegalEntityMapper;
import com.hyperbank.accounts.customerlegalentity.repository.CustomerLegalEntityRepository;
import com.hyperbank.accounts.customerlegalentity.service.CustomerLegalEntityService;
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
public class CustomerLegalEntityServiceImpl implements CustomerLegalEntityService {

	public CustomerLegalEntityServiceImpl(CustomerLegalEntityMapper customerLegalEntityMapper, CustomerLegalEntityRepository customerLegalEntityRepository) {
		createService = new CreateServiceImpl<>(customerLegalEntityRepository, CustomerLegalEntity::getId);
		readService = new ReadServiceImpl<>(customerLegalEntityRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(CustomerLegalEntity.class));
		updateService = new UpdateServiceImpl<>(
				customerLegalEntityRepository,
				customerLegalEntityMapper,
				readService,
				CustomerLegalEntity::getId);
		deleteService = new DeleteServiceImpl<>(customerLegalEntityRepository, readService);
	}

	private final CreateService<Long, CustomerLegalEntity> createService;
	private final ReadService<Long, CustomerLegalEntity> readService;
	private final UpdateService<Long, CustomerLegalEntity> updateService;
	private final DeleteService<Long> deleteService;

	@Override
	@Transactional(readOnly = true)
	public CustomerLegalEntity getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerLegalEntity findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CustomerLegalEntity> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CustomerLegalEntity> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CustomerLegalEntity> findAll() {
		return readService.findAll();
	}

	@Override
	public Long save(CustomerLegalEntity entity) {
		return createService.save(entity);
	}

	@Override
	public CustomerLegalEntity saveAndReturn(CustomerLegalEntity entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<CustomerLegalEntity> entities) {
		return createService.save(entities);
	}

	@Override
	public Collection<CustomerLegalEntity> saveAndReturn(Collection<CustomerLegalEntity> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Long update(CustomerLegalEntity entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public CustomerLegalEntity updateAndReturn(CustomerLegalEntity entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Long> update(Collection<CustomerLegalEntity> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<CustomerLegalEntity> updateAndReturn(Collection<CustomerLegalEntity> entities) throws FunctionalException {
		return updateService.updateAndReturn(entities);
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
	
}
