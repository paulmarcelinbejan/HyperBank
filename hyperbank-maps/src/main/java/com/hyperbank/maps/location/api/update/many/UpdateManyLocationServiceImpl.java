package com.hyperbank.maps.location.api.update.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdateManyLocationServiceImpl implements UpdateManyLocationService {

	private final LocationRepository repository; 

	@Override
	@Transactional
	public List<Location> execute(List<Location> entities) {
		
		return repository.saveAll(entities);
		
	}
	
}
