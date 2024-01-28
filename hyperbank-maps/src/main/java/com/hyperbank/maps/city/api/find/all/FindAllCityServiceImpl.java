package com.hyperbank.maps.city.api.find.all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllCityServiceImpl implements FindAllCityService {

	private final CityRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<City> execute() {
		
		return repository.findAll();
		
	}
	
}
