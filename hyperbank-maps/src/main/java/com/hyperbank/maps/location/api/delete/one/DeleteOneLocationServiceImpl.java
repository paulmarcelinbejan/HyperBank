package com.hyperbank.maps.location.api.delete.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteOneLocationServiceImpl implements DeleteOneLocationService {

	private final LocationRepository repository;

	@Override
	@Transactional
	public void execute(Long id) {
		
		repository.deleteById(id);
	
	}
	
}
