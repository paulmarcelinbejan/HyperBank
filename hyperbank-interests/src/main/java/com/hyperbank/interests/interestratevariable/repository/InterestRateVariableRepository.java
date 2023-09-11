package com.hyperbank.interests.interestratevariable.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.interests.interestratevariable.entity.InterestRateVariable;

@Repository
public interface InterestRateVariableRepository extends JpaRepository<InterestRateVariable, Long> {

	Optional<InterestRateVariable> findByName(String name);
	
}
