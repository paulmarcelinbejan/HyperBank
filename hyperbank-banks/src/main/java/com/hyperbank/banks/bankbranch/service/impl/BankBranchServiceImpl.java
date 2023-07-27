package com.hyperbank.banks.bankbranch.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.banks.bankbranch.dto.BankBranchDto;
import com.hyperbank.banks.bankbranch.entity.BankBranch;
import com.hyperbank.banks.bankbranch.mapper.BankBranchMapper;
import com.hyperbank.banks.bankbranch.repository.BankBranchRepository;
import com.hyperbank.banks.bankbranch.service.BankBranchService;
import com.hyperbank.banks.feignclient.MapsRemoteService;
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

@Service
@Transactional(rollbackFor = { FunctionalException.class, TechnicalException.class })
public class BankBranchServiceImpl implements BankBranchService {

	public BankBranchServiceImpl(
			BankBranchMapper bankBranchMapper,
			BankBranchRepository bankBranchRepository,
			MapsRemoteService mapsRemoteService) {

		readService = new ReadServiceImpl<>(bankBranchMapper, bankBranchRepository, BankBranch.class);
		createService = new CreateServiceImpl<>(bankBranchMapper, bankBranchRepository, BankBranch.class);
		updateService = new UpdateServiceImpl<>(
				bankBranchMapper,
				bankBranchRepository,
				readService,
				BankBranch.class,
				BankBranchDto.class);
		deleteService = new DeleteServiceImpl<>(bankBranchRepository, readService);

		this.mapsRemoteService = mapsRemoteService;
	}

	private final ReadService<Integer, BankBranch, BankBranchDto> readService;
	private final CreateService<Integer, BankBranchDto> createService;
	private final UpdateService<Integer, BankBranchDto> updateService;
	private final DeleteService<Integer> deleteService;

	private final MapsRemoteService mapsRemoteService;

	@Override
	@Transactional(readOnly = true)
	public BankBranch findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public BankBranchDto findByIdToDto(Integer id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BankBranch> findManyById(Collection<Integer> ids) {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BankBranchDto> findManyByIdToDto(Collection<Integer> ids) {
		return readService.findManyByIdToDto(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BankBranch> findAll() {
		return readService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BankBranchDto> findAllToDto() {
		return readService.findAllToDto();
	}

	@Override
	public Integer save(BankBranchDto dto) throws TechnicalException {
		mapsRemoteService.findLocationById(dto.getLocationId()); // Only for validation.
		return createService.save(dto);
	}

	@Override
	public Collection<Integer> save(Collection<BankBranchDto> dtos) throws TechnicalException {
		return createService.save(dtos);
	}

	@Override
	public Integer update(BankBranchDto dto) throws FunctionalException, TechnicalException {
		mapsRemoteService.findLocationById(dto.getLocationId()); // Only for validation.
		return updateService.update(dto);
	}

	@Override
	public Collection<Integer> update(Collection<BankBranchDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteService.delete(id);
	}

	@Override
	public void delete(Collection<Integer> ids) throws FunctionalException {
		deleteService.delete(ids);
	}

	@Override
	public void deleteIfPresent(Collection<Integer> ids) {
		deleteService.deleteIfPresent(ids);
	}

}
