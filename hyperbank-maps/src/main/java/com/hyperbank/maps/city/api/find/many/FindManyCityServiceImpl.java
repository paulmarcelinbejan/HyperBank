package com.hyperbank.maps.city.api.find.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindManyCityServiceImpl implements FindManyCityService {
	
	private final CityRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<City> execute(List<Integer> ids) {
		
		return repository.findAllById(ids);
		
	}
	
}
