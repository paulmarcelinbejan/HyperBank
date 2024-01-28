package com.hyperbank.maps.city.api.save.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveManyCityServiceImpl implements SaveManyCityService {

	private final CityRepository repository;

	@Override
	@Transactional
	public List<City> execute(List<City> entities) {

		return repository.saveAll(entities);
		
	}
	
}
