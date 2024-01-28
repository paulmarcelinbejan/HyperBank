package com.hyperbank.maps.country.api.update.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOneCountryServiceImpl implements UpdateOneCountryService {

	private final CountryRepository repository; 

	@Override
	@Transactional
	public Country execute(Country country) {
		
		return repository.save(country);
		
	}
	
}
