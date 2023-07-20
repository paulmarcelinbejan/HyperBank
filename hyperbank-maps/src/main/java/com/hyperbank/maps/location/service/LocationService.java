package com.hyperbank.maps.location.service;

import com.hyperbank.maps.location.dto.LocationDto;
import com.hyperbank.maps.location.entity.Location;
import com.paulmarcelinbejan.toolbox.web.service.CrudService;

public interface LocationService extends CrudService<Long, Location, LocationDto> {

}
