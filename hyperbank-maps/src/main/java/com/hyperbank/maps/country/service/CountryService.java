package com.hyperbank.maps.country.service;

import com.hyperbank.maps.country.dto.CountryDto;
import com.hyperbank.maps.country.entity.Country;
import com.paulmarcelinbejan.toolbox.web.service.CrudService;

public interface CountryService extends CrudService<Integer, Country, CountryDto> {

}
