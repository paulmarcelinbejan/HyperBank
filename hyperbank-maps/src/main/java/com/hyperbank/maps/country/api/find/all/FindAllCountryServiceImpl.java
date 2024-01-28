package com.hyperbank.maps.country.api.find.all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllCountryServiceImpl implements FindAllCountryService {

	private final CountryRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Country> execute() {
		
		return repository.findAll();
		
	}
	
}
