package com.hyperbank.maps.location.api.find.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindManyLocationServiceImpl implements FindManyLocationService {
	
	private final LocationRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Location> execute(List<Long> ids) {
		
		return repository.findAllById(ids);
		
	}
	
}
