package com.hyperbank.interests.interestratefixed.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.interests.interestratefixed.entity.InterestRateFixed;

@Repository
public interface InterestRateFixedRepository extends JpaRepository<InterestRateFixed, Long> {

	Optional<InterestRateFixed> findByPercentage(BigDecimal percentage);
	
}
