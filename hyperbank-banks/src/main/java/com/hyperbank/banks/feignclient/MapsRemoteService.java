package com.hyperbank.banks.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hyperbank.architecture.web.feign.configuration.ClientConfiguration;
import com.hyperbank.banks.feignclient.response.LocationDto;

@FeignClient(name = "mapsClient", url = "http://localhost:9888", configuration = ClientConfiguration.class)
public interface MapsRemoteService {

	@GetMapping(value = "/api/location/{id}")
	LocationDto findLocationById(@PathVariable("id") Long id);

}