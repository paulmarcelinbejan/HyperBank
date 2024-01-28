package com.hyperbank.maps.continent.api.find.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.repository.ContinentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindManyContinentServiceImpl implements FindManyContinentService {
	
	private final ContinentRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Continent> execute(List<Integer> ids) {
		
		return repository.findAllById(ids);
		
	}
	
}
