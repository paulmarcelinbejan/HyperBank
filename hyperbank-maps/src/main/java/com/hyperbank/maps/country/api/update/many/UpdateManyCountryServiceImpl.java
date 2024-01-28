package com.hyperbank.maps.country.api.update.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateManyCountryServiceImpl implements UpdateManyCountryService {

	private final CountryRepository repository; 

	@Override
	@Transactional
	public List<Country> execute(List<Country> entities) {
		
		return repository.saveAll(entities);
		
	}
	
}
