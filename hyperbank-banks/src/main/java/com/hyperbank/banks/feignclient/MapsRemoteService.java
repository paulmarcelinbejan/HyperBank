package com.hyperbank.banks.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hyperbank.architecture.web.feign.configuration.HyperBankClientConfiguration;
import com.hyperbank.banks.feignclient.response.LocationResponse;

@FeignClient(name = "mapsClient", url = "http://${services.hyperbank-maps.host}:${services.hyperbank-maps.port}", configuration = HyperBankClientConfiguration.class)
public interface MapsRemoteService {

	@GetMapping(value = "/api/location/{id}")
	LocationResponse findLocationById(@PathVariable("id") Long id);

}