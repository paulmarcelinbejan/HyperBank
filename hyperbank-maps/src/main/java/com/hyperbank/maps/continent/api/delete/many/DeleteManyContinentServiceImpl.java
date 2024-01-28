package com.hyperbank.maps.continent.api.delete.many;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.repository.ContinentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteManyContinentServiceImpl implements DeleteManyContinentService {

	private final ContinentRepository repository;
	
	/**
	 * DELETE ALL BY ID
	 * <br>Entities that aren't found in the persistence store are silently ignored.
	 */
	@Override
	@Transactional
	public void execute(List<Integer> ids) {
		
		repository.deleteAllById(ids);
		
	}
	
}
