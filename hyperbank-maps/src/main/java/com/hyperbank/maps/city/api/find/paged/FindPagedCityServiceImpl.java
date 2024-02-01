package com.hyperbank.maps.city.api.find.paged;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hyperbank.maps.city.entity.City;
import com.hyperbank.maps.city.repository.CityRepository;
import com.hyperbank.maps.city.specification.CitySpecification;

import io.github.paulmarcelinbejan.toolbox.exception.functional.FunctionalException;
import io.github.paulmarcelinbejan.toolbox.exception.technical.TechnicalException;
import io.github.paulmarcelinbejan.toolbox.web.request.PagedRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindPagedCityServiceImpl implements FindPagedCityService {

	private final CityRepository repository;

	@Override
	@Transactional(readOnly = true)
	public Page<City> execute(PagedRequest request) throws FunctionalException, TechnicalException {
		CitySpecification specification = new CitySpecification(request);

		// 0 page is 0 index
		int currentPage = request.getPage() - 1;

		return repository.findAll(specification, PageRequest.of(currentPage, request.getElementsForPage()));
	}

}
