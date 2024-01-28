package com.hyperbank.maps.country.api.find.one;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.country.entity.Country;
import com.hyperbank.maps.country.repository.CountryRepository;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindOneCountryServiceImpl implements FindOneCountryService {

	private final CountryRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Country execute(Integer id) throws FunctionalException {
		
		return repository.findById(id)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Country.class), id)));
	
	}
	
}
