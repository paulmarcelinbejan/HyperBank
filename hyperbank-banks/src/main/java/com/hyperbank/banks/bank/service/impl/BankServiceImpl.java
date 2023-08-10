package com.hyperbank.banks.bank.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.banks.bank.dto.BankDto;
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
		createService = new CreateServiceImpl<>(bankMapper, bankRepository, Bank::getId);
		readService = new ReadServiceImpl<>(bankMapper, bankRepository, ServiceUtils.buildErrorMessageIfEntityNotFound(Bank.class));
		updateService = new UpdateServiceImpl<>(
				bankMapper,
				bankRepository,
				readService,
				Bank::getId,
				BankDto::getId);
		deleteService = new DeleteServiceImpl<>(bankRepository, readService);
	}

	private final CreateService<Integer, BankDto> createService;
	private final ReadService<Integer, Bank, BankDto> readService;
	private final UpdateService<Integer, BankDto> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Bank findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public BankDto findByIdToDto(Integer id) throws FunctionalException {
		return readService.findByIdToDto(id);
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
	public Collection<BankDto> findManyByIdToDto(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyByIdToDto(ids);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<BankDto> findManyByIdToDtoIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdToDtoIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Bank> findAll() {
		return readService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<BankDto> findAllToDto() {
		return readService.findAllToDto();
	}

	@Override
	public Integer save(BankDto dto) throws TechnicalException {
		return createService.save(dto);
	}

	@Override
	public Collection<Integer> save(Collection<BankDto> dtos) throws TechnicalException {
		return createService.save(dtos);
	}

	@Override
	public Integer update(BankDto dto) throws FunctionalException, TechnicalException {
		return updateService.update(dto);
	}

	@Override
	public BankDto updateAndReturn(BankDto dto) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dto);
	}
	
	@Override
	public Collection<Integer> update(Collection<BankDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}
	
	@Override
	public Collection<BankDto> updateAndReturn(Collection<BankDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dtos);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteService.delete(id);
	}
	
	@Override
	public void deleteIfPresent(Integer id) throws FunctionalException {
		deleteService.deleteIfPresent(id);
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
