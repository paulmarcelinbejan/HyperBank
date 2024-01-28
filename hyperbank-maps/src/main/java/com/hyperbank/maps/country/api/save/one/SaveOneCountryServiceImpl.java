package com.hyperbank.maps.country.api.save.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveOneCountryServiceImpl implements SaveOneCountryService {

	private final CountryRepository repository;

	@Override
	@Transactional
	public Country execute(Country entity) {
		
		return repository.save(entity);
		
	}
	
}
