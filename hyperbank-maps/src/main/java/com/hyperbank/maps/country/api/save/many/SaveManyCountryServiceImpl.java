package com.hyperbank.maps.country.api.save.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveManyCountryServiceImpl implements SaveManyCountryService {

	private final CountryRepository repository;

	@Override
	@Transactional
	public List<Country> execute(List<Country> entities) {

		return repository.saveAll(entities);
		
	}
	
}
