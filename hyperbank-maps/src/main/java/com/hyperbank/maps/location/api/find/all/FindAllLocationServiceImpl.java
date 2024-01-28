package com.hyperbank.maps.location.api.find.all;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindAllLocationServiceImpl implements FindAllLocationService {

	private final LocationRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Location> execute() {
		
		return repository.findAll();
		
	}
	
}
