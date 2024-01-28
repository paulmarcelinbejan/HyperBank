package com.hyperbank.maps.city.api.delete.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.repository.CityRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteOneCityServiceImpl implements DeleteOneCityService {

	private final CityRepository repository;

	@Override
	@Transactional
	public void execute(Integer id) {
		
		repository.deleteById(id);
	
	}
	
}
