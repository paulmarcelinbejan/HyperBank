package com.hyperbank.interests.interestrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.interests.interestrate.entity.InterestRate;

@Repository
public interface InterestRateRepository extends JpaRepository<InterestRate, Long> {

}
