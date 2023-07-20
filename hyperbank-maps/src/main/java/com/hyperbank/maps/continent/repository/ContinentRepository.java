package com.hyperbank.maps.continent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.maps.continent.entity.Continent;

@Repository
public interface ContinentRepository extends JpaRepository<Continent, Integer> {

}
