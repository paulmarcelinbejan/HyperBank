package com.hyperbank.banks.bankbranch.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.banks.bankbranch.entity.BankBranch;
import com.hyperbank.banks.bankbranch.mapper.BankBranchMapper;
import com.hyperbank.banks.bankbranch.repository.BankBranchRepository;
import com.hyperbank.banks.bankbranch.service.BankBranchService;
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
public class BankBranchServiceImpl implements BankBranchService {

	public BankBranchServiceImpl(BankBranchMapper bankBranchMapper, BankBranchRepository bankBranchRepository) {
		createService = new CreateServiceImpl<>(bankBranchRepository, BankBranch::getId);
		readService = new ReadServiceImpl<>(bankBranchRepository, ServiceUtils.buildErrorMessageIfEntityNotFoundById(BankBranch.class));
		updateService = new UpdateServiceImpl<>(
				bankBranchRepository,
				bankBranchMapper,
				readService,
				BankBranch::getId);
		deleteService = new DeleteServiceImpl<>(bankBranchRepository, readService);
	}

	private final CreateService<Integer, BankBranch> createService;
	private final ReadService<Integer, BankBranch> readService;
	private final UpdateService<Integer, BankBranch> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public BankBranch getReferenceById(Integer id) {
		return readService.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public BankBranch findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BankBranch> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BankBranch> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BankBranch> findAll() {
		return readService.findAll();
	}

	@Override
	public Integer save(BankBranch entity) {
		return createService.save(entity);
	}
	
	@Override
	public BankBranch saveAndReturn(BankBranch entity) {
		return createService.saveAndReturn(entity);
	}

	@Override
	public Collection<Integer> save(Collection<BankBranch> entities) {
		return createService.save(entities);
	}
	
	@Override
	public Collection<BankBranch> saveAndReturn(Collection<BankBranch> entities) {
		return createService.saveAndReturn(entities);
	}


	@Override
	public Integer update(BankBranch entity) throws FunctionalException {
		return updateService.update(entity);
	}

	@Override
	public BankBranch updateAndReturn(BankBranch entity) throws FunctionalException {
		return updateService.updateAndReturn(entity);
	}
	
	@Override
	public Collection<Integer> update(Collection<BankBranch> entities) throws FunctionalException {
		return updateService.update(entities);
	}
	
	@Override
	public Collection<BankBranch> updateAndReturn(Collection<BankBranch> entities) throws FunctionalException {
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
