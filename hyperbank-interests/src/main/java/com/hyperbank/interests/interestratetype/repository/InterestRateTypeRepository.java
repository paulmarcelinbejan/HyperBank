package com.hyperbank.interests.interestratetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.interests.interestratetype.entity.InterestRateType;

@Repository
public interface InterestRateTypeRepository extends JpaRepository<InterestRateType, Integer> {

}
