package com.hyperbank.maps.country.api.delete.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.repository.CountryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteOneCountryServiceImpl implements DeleteOneCountryService {

	private final CountryRepository repository;

	@Override
	@Transactional
	public void execute(Integer id) {
		
		repository.deleteById(id);
	
	}
	
}
