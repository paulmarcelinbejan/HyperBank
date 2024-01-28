package com.hyperbank.maps.continent.api.save.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.repository.ContinentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveOneContinentServiceImpl implements SaveOneContinentService {

	private final ContinentRepository repository;

	@Override
	@Transactional
	public Continent execute(Continent entity) {
		
		return repository.save(entity);
		
	}
	
}
