package com.hyperbank.accounts.customerindividual.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.accounts.customerindividual.entity.CustomerIndividual;
import com.hyperbank.accounts.customerindividual.mapper.CustomerIndividualMapper;
import com.hyperbank.accounts.customerindividual.repository.CustomerIndividualRepository;
import com.hyperbank.accounts.customerindividual.service.CustomerIndividualService;
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
public class CustomerIndividualServiceImpl implements CustomerIndividualService {

	public CustomerIndividualServiceImpl(CustomerIndividualMapper customerIndividualMapper, CustomerIndividualRepository customerIndividualRepository) {
		createService = new CreateServiceImpl<>(customerIndividualRepository, CustomerIndividual::getId);
		readService = new ReadServiceImpl<>(customerIndividualRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(CustomerIndividual.class));
		updateService = new UpdateServiceImpl<>(
				customerIndividualRepository,
				customerIndividualMapper,
				readService,
				CustomerIndividual::getId);
		deleteService = new DeleteServiceImpl<>(customerIndividualRepository, readService);
	}

	private final CreateService<Long, CustomerIndividual> createService;
	private final ReadService<Long, CustomerIndividual> readService;
	private final UpdateService<Long, CustomerIndividual> updateService;
	private final DeleteService<Long> deleteService;

	@Override
	@Transactional(readOnly = true)
	public CustomerIndividual getReferenceById(Long id) {
		return readService.getReferenceById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public CustomerIndividual findById(Long id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CustomerIndividual> findManyById(Collection<Long> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CustomerIndividual> findManyByIdIfPresent(Collection<Long> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<CustomerIndividual> findAll() {
		return readService.findAll();
	}

	@Override
	public Long save(CustomerIndividual entity) {
		return createService.save(entity);
	}

	@Override
	public CustomerIndividual saveAndReturn(CustomerIndividual entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Long> save(Collection<CustomerIndividual> entities) {
		return createService.save(entities);
	}

	@Override
	public Collection<CustomerIndividual> saveAndReturn(Collection<CustomerIndividual> entities) {
		return createService.saveAndReturn(entities);
	}

	@Override
	public Long update(CustomerIndividual entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public CustomerIndividual updateAndReturn(CustomerIndividual entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Long> update(Collection<CustomerIndividual> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<CustomerIndividual> updateAndReturn(Collection<CustomerIndividual> entities) throws FunctionalException {
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
