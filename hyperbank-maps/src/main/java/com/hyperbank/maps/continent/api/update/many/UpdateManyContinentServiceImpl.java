package com.hyperbank.maps.continent.api.update.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.repository.ContinentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateManyContinentServiceImpl implements UpdateManyContinentService {

	private final ContinentRepository repository; 

	@Override
	@Transactional
	public List<Continent> execute(List<Continent> entities) {
		
		return repository.saveAll(entities);
		
	}
	
}
