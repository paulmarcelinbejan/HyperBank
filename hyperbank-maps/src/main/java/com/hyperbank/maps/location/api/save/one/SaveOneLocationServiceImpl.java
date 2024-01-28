package com.hyperbank.maps.location.api.save.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaveOneLocationServiceImpl implements SaveOneLocationService {

	private final LocationRepository repository;

	@Override
	@Transactional
	public Location execute(Location entity) {
		
		return repository.save(entity);
		
	}
	
}
