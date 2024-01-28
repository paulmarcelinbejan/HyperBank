package com.hyperbank.maps.location.api.delete.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteManyLocationServiceImpl implements DeleteManyLocationService {

	private final LocationRepository repository;
	
	/**
	 * DELETE ALL BY ID
	 * <br>Entities that aren't found in the persistence store are silently ignored.
	 */
	@Override
	@Transactional
	public void execute(List<Long> ids) {
		
		repository.deleteAllById(ids);
		
	}
	
}
