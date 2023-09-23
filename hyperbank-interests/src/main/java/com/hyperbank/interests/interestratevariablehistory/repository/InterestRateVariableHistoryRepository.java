package com.hyperbank.interests.interestratevariablehistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;

@Repository
public interface InterestRateVariableHistoryRepository extends JpaRepository<InterestRateVariableHistory, Long> {

}
