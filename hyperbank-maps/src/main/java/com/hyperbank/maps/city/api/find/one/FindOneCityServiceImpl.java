package com.hyperbank.maps.city.api.find.one;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.repository.CityRepository;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindOneCityServiceImpl implements FindOneCityService {

	private final CityRepository repository;

	@Override
	@Transactional(readOnly = true)
	public City execute(Integer id) throws FunctionalException {
		
		return repository.findById(id)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(City.class), id)));
	
	}
	
}
