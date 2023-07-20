package com.hyperbank.maps.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.maps.country.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

}
