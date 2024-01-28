package com.hyperbank.maps.continent.api.update.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.repository.ContinentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOneContinentServiceImpl implements UpdateOneContinentService {

	private final ContinentRepository repository; 

	@Override
	@Transactional
	public Continent execute(Continent continent) {
		
		return repository.save(continent);
		
	}
	
}
