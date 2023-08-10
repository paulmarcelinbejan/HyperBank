package com.hyperbank.maps.continent.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.dto.ContinentDto;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.ContinentMapper;
import com.hyperbank.maps.continent.repository.ContinentRepository;
import com.hyperbank.maps.continent.service.ContinentService;
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
public class ContinentServiceImpl implements ContinentService {

	public ContinentServiceImpl(ContinentMapper continentMapper, ContinentRepository continentRepository) {
		createService = new CreateServiceImpl<>(continentMapper, continentRepository, Continent::getId);
		readService = new ReadServiceImpl<>(continentMapper, continentRepository, ServiceUtils.buildErrorMessageIfEntityNotFound(Continent.class));
		updateService = new UpdateServiceImpl<>(
				continentMapper,
				continentRepository,
				readService,
				Continent::getId,
				ContinentDto::getId);
		deleteService = new DeleteServiceImpl<>(continentRepository, readService);
	}

	private final CreateService<Integer, ContinentDto> createService;
	private final ReadService<Integer, Continent, ContinentDto> readService;
	private final UpdateService<Integer, ContinentDto> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	@Transactional(readOnly = true)
	public Continent findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ContinentDto findByIdToDto(Integer id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Continent> findManyById(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyById(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Continent> findManyByIdIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdIfPresent(ids);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<ContinentDto> findManyByIdToDto(Collection<Integer> ids) throws FunctionalException {
		return readService.findManyByIdToDto(ids);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Collection<ContinentDto> findManyByIdToDtoIfPresent(Collection<Integer> ids) {
		return readService.findManyByIdToDtoIfPresent(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Continent> findAll() {
		return readService.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<ContinentDto> findAllToDto() {
		return readService.findAllToDto();
	}

	@Override
	public Integer save(ContinentDto dto) throws TechnicalException {
		return createService.save(dto);
	}

	@Override
	public Collection<Integer> save(Collection<ContinentDto> dtos) throws TechnicalException {
		return createService.save(dtos);
	}

	@Override
	public Integer update(ContinentDto dto) throws FunctionalException, TechnicalException {
		return updateService.update(dto);
	}

	@Override
	public ContinentDto updateAndReturn(ContinentDto dto) throws FunctionalException, TechnicalException {
		return updateService.updateAndReturn(dto);
	}
	
	@Override
	public Collection<Integer> update(Collection<ContinentDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}
	
	@Override
	public Collection<ContinentDto> updateAndReturn(Collection<ContinentDto> dtos) throws FunctionalException, TechnicalException {
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
