package com.hyperbank.maps.location.api.update.one;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateOneLocationServiceImpl implements UpdateOneLocationService {

	private final LocationRepository repository; 

	@Override
	@Transactional
	public Location execute(Location location) {
		
		return repository.save(location);
		
	}
	
}
