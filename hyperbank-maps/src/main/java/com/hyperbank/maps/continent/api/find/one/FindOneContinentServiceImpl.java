package com.hyperbank.maps.continent.api.find.one;

import java.text.MessageFormat;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.continent.entity.Continent;
import com.hyperbank.maps.continent.repository.ContinentRepository;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.service.helper.utils.ServiceHelperUtils;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindOneContinentServiceImpl implements FindOneContinentService {

	private final ContinentRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Continent execute(Integer id) throws FunctionalException {
		
		return repository.findById(id)
				.orElseThrow(() -> new FunctionalException(MessageFormat.format(ServiceHelperUtils.buildErrorMessageIfEntityNotFoundById(Continent.class), id)));
	
	}
	
}
