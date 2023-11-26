package com.hyperbank.banks.bankbranch.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.banks.bankbranch.entity.BankBranch;
import com.hyperbank.banks.bankbranch.mapper.BankBranchMapper;
import com.hyperbank.banks.bankbranch.repository.BankBranchRepository;
import com.hyperbank.banks.bankbranch.service.BankBranchService;
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
public class BankBranchServiceImpl implements BankBranchService {

	public BankBranchServiceImpl(BankBranchMapper bankBranchMapper, BankBranchRepository bankBranchRepository) {
		createServiceHelper = new CreateServiceHelperImpl<>(bankBranchRepository, BankBranch::getId);
		readServiceHelper = new ReadServiceHelperImpl<>(bankBranchRepository, ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(BankBranch.class));
		updateServiceHelper = new UpdateServiceHelperImpl<>(
				bankBranchRepository,
				bankBranchMapper,
				readServiceHelper,
				BankBranch::getId);
		deleteServiceHelper = new DeleteServiceHelperImpl<>(bankBranchRepository, readServiceHelper);
	}

	private final CreateServiceHelper<Integer, BankBranch> createServiceHelper;
	private final ReadServiceHelper<Integer, BankBranch> readServiceHelper;
	private final UpdateServiceHelper<Integer, BankBranch> updateServiceHelper;
	private final DeleteServiceHelper<Integer> deleteServiceHelper;

	@Override
	@Transactional(readOnly = true)
	public BankBranch getReferenceById(Integer id) {
		return readServiceHelper.getReferenceById(id);
	}
	
	@Override
	@Transactional(readOnly = true)
	public BankBranch findById(Integer id) throws FunctionalException {
		return readServiceHelper.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BankBranch> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readServiceHelper.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BankBranch> findManyByIdIfPresent(Collection<Integer> ids) {
		return readServiceHelper.findManyByIdIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public List<BankBranch> findAll() {
		return readServiceHelper.findAll();
	}

	@Override
	public Integer save(BankBranch entity) throws FunctionalException {
		return createServiceHelper.save(entity);
	}
	
	@Override
	public BankBranch saveAndReturn(BankBranch entity) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entity);
	}

	@Override
	public List<Integer> save(Collection<BankBranch> entities) throws FunctionalException {
		return createServiceHelper.save(entities);
	}
	
	@Override
	public List<BankBranch> saveAndReturn(Collection<BankBranch> entities) throws FunctionalException {
		return createServiceHelper.saveAndReturn(entities);
	}


	@Override
	public Integer update(BankBranch entity) throws FunctionalException {
		return updateServiceHelper.update(entity);
	}

	@Override
	public BankBranch updateAndReturn(BankBranch entity) throws FunctionalException {
		return updateServiceHelper.updateAndReturn(entity);
	}
	
	@Override
	public List<Integer> update(Collection<BankBranch> entities) throws FunctionalException {
		return updateServiceHelper.update(entities);
	}
	
	@Override
	public List<BankBranch> updateAndReturn(Collection<BankBranch> entities) throws FunctionalException {
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
