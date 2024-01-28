package com.hyperbank.maps.continent.api.delete.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.repository.ContinentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteOneContinentServiceImpl implements DeleteOneContinentService {

	private final ContinentRepository repository;

	@Override
	@Transactional
	public void execute(Integer id) {
		
		repository.deleteById(id);
	
	}
	
}
