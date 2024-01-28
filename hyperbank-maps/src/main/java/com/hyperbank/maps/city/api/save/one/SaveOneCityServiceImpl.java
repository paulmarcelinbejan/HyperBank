package com.hyperbank.maps.city.api.save.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveOneCityServiceImpl implements SaveOneCityService {

	private final CityRepository repository;

	@Override
	@Transactional
	public City execute(City entity) {
		
		return repository.save(entity);
		
	}
	
}
