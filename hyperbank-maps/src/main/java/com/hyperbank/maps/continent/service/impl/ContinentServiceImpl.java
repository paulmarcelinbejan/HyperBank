package com.hyperbank.maps.continent.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.dto.ContinentDto;
import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.mapper.ContinentMapper;
import com.hyperbank.maps.continent.repository.ContinentRepository;
import com.hyperbank.maps.continent.service.ContinentService;
import com.paulmarcelinbejan.toolbox.exception.technical.FunctionalException;
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
public class ContinentServiceImpl implements ContinentService {

	public ContinentServiceImpl(ContinentMapper continentMapper, ContinentRepository continentRepository) {
		readService = new ReadServiceImpl<>(continentMapper, continentRepository, Continent.class);
		createService = new CreateServiceImpl<>(continentMapper, continentRepository, Continent.class);
		updateService = new UpdateServiceImpl<>(
				continentMapper,
				continentRepository,
				readService,
				Continent.class,
				ContinentDto.class);
		deleteService = new DeleteServiceImpl<>(continentRepository, readService);
	}

	private final ReadService<Integer, Continent, ContinentDto> readService;
	private final CreateService<Integer, ContinentDto> createService;
	private final UpdateService<Integer, ContinentDto> updateService;
	private final DeleteService<Integer> deleteService;

	@Override
	public Continent findById(Integer id) throws FunctionalException {
		return readService.findById(id);
	}

	@Override
	public ContinentDto findByIdToDto(Integer id) throws FunctionalException {
		return readService.findByIdToDto(id);
	}

	/**
	 * If some or all ids are not found, no entities are returned for these IDs.
	 */
	@Override
	public Collection<Continent> findManyById(Collection<Integer> ids) {
		return readService.findManyById(ids);
	}

	/**
	 * If some or all ids are not found, no DTOs are returned for these IDs.
	 */
	@Override
	public Collection<ContinentDto> findManyByIdToDto(Collection<Integer> ids) {
		return readService.findManyByIdToDto(ids);
	}

	@Override
	public Collection<Continent> findAll() {
		return readService.findAll();
	}

	@Override
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
	public Collection<Integer> update(Collection<ContinentDto> dtos) throws FunctionalException, TechnicalException {
		return updateService.update(dtos);
	}

	@Override
	public void delete(Integer id) throws FunctionalException {
		deleteService.delete(id);
	}

	/**
	 * If an Entity is not found in the persistence store, a FunctionalException
	 * will be thrown.
	 */
	@Override
	public void delete(Collection<Integer> ids) throws FunctionalException {
		deleteService.delete(ids);
	}

	/**
	 * Entities that aren't found in the persistence store are silently ignored.
	 */
	@Override
	public void deleteIfPresent(Collection<Integer> ids) {
		deleteService.deleteIfPresent(ids);
	}

}
