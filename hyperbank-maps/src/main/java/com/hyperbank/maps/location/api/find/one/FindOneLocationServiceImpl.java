package com.hyperbank.maps.location.api.find.one;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.location.entity.Location;
import com.hyperbank.maps.location.repository.LocationRepository;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindOneLocationServiceImpl implements FindOneLocationService {

	private final LocationRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Location execute(Long id) throws FunctionalException {
		
		return repository.findById(id)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Location.class), id)));
	
	}
	
}
